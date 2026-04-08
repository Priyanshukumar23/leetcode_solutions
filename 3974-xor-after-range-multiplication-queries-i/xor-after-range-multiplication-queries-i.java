class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1000000007;

        // Process each query
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];

            for (int idx = l; idx <= r; idx += k) {
                long val = nums[idx];
                val = (val * v) % MOD;
                nums[idx] = (int) val;
            }
        }

        // Compute XOR of all elements
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}