import java.util.Arrays;

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        // Segment Tree to store the difference (Distinct Even - Distinct Odd)
        // size 4*n for the tree
        SegmentTree st = new SegmentTree(n);
        
        // Map to store the last occurrence index of each number
        // Constraints: 1 <= nums[i] <= 10^5, so size 100001 is sufficient (plus buffer)
        int[] lastSeen = new int[100005];
        Arrays.fill(lastSeen, -1);
        
        int maxLen = 0;
        
        for (int r = 0; r < n; r++) {
            int num = nums[r];
            int val = (num % 2 == 0) ? 1 : -1;
            int prev = lastSeen[num];
            
            // Update the range [prev + 1, r]
            // This range represents all start indices L for which 'num' is a newly distinct element
            st.update(1, 0, n - 1, prev + 1, r, val);
            
            // Update last seen position
            lastSeen[num] = r;
            
            // Query for the smallest index L in [0, r] where the value is 0
            int l = st.queryFirstZero(1, 0, n - 1, 0, r);
            
            if (l != -1) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }
        
        return maxLen;
    }

    static class SegmentTree {
        int[] min;
        int[] max;
        int[] lazy;
        int n;

        public SegmentTree(int n) {
            this.n = n;
            min = new int[4 * n];
            max = new int[4 * n];
            lazy = new int[4 * n];
            // Initially all values are 0, which is correct because
            // before any updates, "diff count" is effectively 0.
        }

        private void push(int node) {
            if (lazy[node] != 0) {
                lazy[2 * node] += lazy[node];
                min[2 * node] += lazy[node];
                max[2 * node] += lazy[node];

                lazy[2 * node + 1] += lazy[node];
                min[2 * node + 1] += lazy[node];
                max[2 * node + 1] += lazy[node];

                lazy[node] = 0;
            }
        }

        public void update(int node, int start, int end, int l, int r, int val) {
            if (l > end || r < start) {
                return;
            }
            if (l <= start && end <= r) {
                min[node] += val;
                max[node] += val;
                lazy[node] += val;
                return;
            }
            push(node);
            int mid = (start + end) / 2;
            update(2 * node, start, mid, l, r, val);
            update(2 * node + 1, mid + 1, end, l, r, val);
            min[node] = Math.min(min[2 * node], min[2 * node + 1]);
            max[node] = Math.max(max[2 * node], max[2 * node + 1]);
        }

        // Returns the leftmost index in query range [qL, qR] that has value 0
        public int queryFirstZero(int node, int start, int end, int qL, int qR) {
            // If the current node range is completely outside query range
            if (start > qR || end < qL) {
                return -1;
            }
            
            // Optimization: If 0 is not within the range [min, max], it doesn't exist here.
            // This relies on the property that the function values change by at most 1 between adjacent indices.
            if (min[node] > 0 || max[node] < 0) {
                return -1;
            }

            // If leaf node, check if it's 0 (the min/max check passed, so it must be 0)
            if (start == end) {
                return (min[node] == 0) ? start : -1;
            }

            push(node);
            int mid = (start + end) / 2;
            
            // Try left child first to find the smallest index
            int res = queryFirstZero(2 * node, start, mid, qL, qR);
            if (res != -1) {
                return res;
            }
            
            // If not found in left, try right
            return queryFirstZero(2 * node + 1, mid + 1, end, qL, qR);
        }
    }
}