class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        // dp[i][j][k]: max coins at (i,j) using k neutralizations
        int[][][] dp = new int[m][n][3];

        // Initialize with very small value
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        // Start point
        dp[0][0][0] = coins[0][0];
        if (coins[0][0] < 0) {
            dp[0][0][1] = 0; // neutralize
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {

                    if (dp[i][j][k] == Integer.MIN_VALUE) continue;

                    // Move right
                    if (j + 1 < n) {
                        int val = coins[i][j + 1];

                        // Without neutralization
                        dp[i][j + 1][k] = Math.max(dp[i][j + 1][k],
                                dp[i][j][k] + val);

                        // With neutralization
                        if (val < 0 && k < 2) {
                            dp[i][j + 1][k + 1] = Math.max(dp[i][j + 1][k + 1],
                                    dp[i][j][k]);
                        }
                    }

                    // Move down
                    if (i + 1 < m) {
                        int val = coins[i + 1][j];

                        // Without neutralization
                        dp[i + 1][j][k] = Math.max(dp[i + 1][j][k],
                                dp[i][j][k] + val);

                        // With neutralization
                        if (val < 0 && k < 2) {
                            dp[i + 1][j][k + 1] = Math.max(dp[i + 1][j][k + 1],
                                    dp[i][j][k]);
                        }
                    }
                }
            }
        }

        // Answer = max of all k at destination
        int result = Integer.MIN_VALUE;
        for (int k = 0; k < 3; k++) {
            result = Math.max(result, dp[m - 1][n - 1][k]);
        }

        return result;
    }
}