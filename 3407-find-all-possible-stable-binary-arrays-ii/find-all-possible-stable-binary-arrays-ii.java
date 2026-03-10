class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        long[][][] dp = new long[zero + 1][one + 1][2];
        long MOD = 1000000007;

        // Base cases: arrays strictly made of 0s or strictly made of 1s
        for (int i = 1; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }
        for (int j = 1; j <= Math.min(one, limit); j++) {
            dp[0][j][1] = 1;
        }

        // Fill the DP table
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                
                // Calculate ending in 0
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
                if (i > limit) {
                    // Subtract the invalid sequences that exceed the limit
                    dp[i][j][0] = (dp[i][j][0] - dp[i - limit - 1][j][1] + MOD) % MOD;
                }

                // Calculate ending in 1
                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
                if (j > limit) {
                    // Subtract the invalid sequences that exceed the limit
                    dp[i][j][1] = (dp[i][j][1] - dp[i][j - limit - 1][0] + MOD) % MOD;
                }
            }
        }

        // The answer is the sum of valid arrays ending in 0 and ending in 1
        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}