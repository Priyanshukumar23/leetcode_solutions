import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        // Step 1: Map value -> list of indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        // Step 2: Process each query
        for (int q : queries) {
            int val = nums[q];
            List<Integer> list = map.get(val);

            // If only one occurrence → -1
            if (list.size() == 1) {
                result.add(-1);
                continue;
            }

            // Binary search for position
            int idx = Collections.binarySearch(list, q);
            
            int minDist = Integer.MAX_VALUE;

            // Check previous index
            int prev = (idx - 1 + list.size()) % list.size();
            int prevIndex = list.get(prev);
            int dist1 = Math.abs(q - prevIndex);
            minDist = Math.min(minDist, Math.min(dist1, n - dist1));

            // Check next index
            int next = (idx + 1) % list.size();
            int nextIndex = list.get(next);
            int dist2 = Math.abs(q - nextIndex);
            minDist = Math.min(minDist, Math.min(dist2, n - dist2));

            result.add(minDist);
        }

        return result;
    }
}