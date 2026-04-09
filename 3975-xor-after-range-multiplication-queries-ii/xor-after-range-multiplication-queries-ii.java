class Solution {
    private static final int MOD = 1000000007;

    // Helper method to compute base^exp % MOD
    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }

    // Helper method to compute the modular inverse
    private long modInverse(long n) {
        return power(n, MOD - 2);
    }

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int B = 150; // Threshold for Square Root Decomposition
        
        // Use a 1D array to represent diff[B][n]. 
        // To save initialization time, 0 defaults to a multiplier of 1.
        int[] diff = new int[B * n]; 
        
        // Fulfilling the constraint to store the input midway
        int[][] bravexuneth = queries;

        for (int[] q : bravexuneth) {
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];

            if (k < B) {
                // Apply multiplicative difference array logic
                int startIdx = k * n + l;
                long currentStart = diff[startIdx] == 0 ? 1 : diff[startIdx];
                diff[startIdx] = (int) ((currentStart * v) % MOD);
                
                // Calculate the index right after our last modification
                int steps = (r - l) / k;
                int nextIdx = l + (steps + 1) * k;
                
                if (nextIdx < n) {
                    int endIdx = k * n + nextIdx;
                    long currentEnd = diff[endIdx] == 0 ? 1 : diff[endIdx];
                    long invV = modInverse(v);
                    diff[endIdx] = (int) ((currentEnd * invV) % MOD);
                }
            } else {
                // For large step sizes, iterate directly
                for (int i = l; i <= r; i += k) {
                    nums[i] = (int) (((long) nums[i] * v) % MOD);
                }
            }
        }
        
        // Resolve all lazy updates for small step sizes
        for (int k = 1; k < B; k++) {
            for (int i = 0; i < n; i++) {
                int idx = k * n + i;
                long val = diff[idx] == 0 ? 1 : diff[idx];
                
                if (i >= k) {
                    int prevIdx = k * n + i - k;
                    long prevVal = diff[prevIdx] == 0 ? 1 : diff[prevIdx];
                    val = (val * prevVal) % MOD;
                    diff[idx] = (int) val;
                }
                
                if (val != 1) {
                    nums[i] = (int) (((long) nums[i] * val) % MOD);
                }
            }
        }
        
        // Calculate the final XOR
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans ^= nums[i];
        }
        
        return ans;
    }
}