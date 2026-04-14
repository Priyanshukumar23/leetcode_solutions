import java.util.*;

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        // Sort robots and factories by their positions to ensure optimal assignment
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));
        
        int n = robot.size();
        int m = factory.length;
        
        // dp[i][j] represents the min distance to repair first i robots using first j factories
        long[][] dp = new long[n + 1][m + 1];
        
        // 10^15 is safely greater than the max possible distance (which is ~ 2 * 10^11)
        long INF = 1_000_000_000_000_000L; 
        
        // Initialize DP array with infinity for impossible states
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }
        
        // Base case: 0 robots cost 0 distance
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        
        for (int j = 1; j <= m; j++) {
            long pos = factory[j - 1][0];
            int limit = factory[j - 1][1];
            
            for (int i = 1; i <= n; i++) {
                // Option 1: Don't assign any robots to the current factory
                dp[i][j] = dp[i][j - 1];
                
                // Option 2: Assign k robots to the current factory
                long currentCost = 0;
                
                // Assign up to 'limit' robots, ensuring we don't go out of bounds
                for (int k = 1; k <= limit && i - k >= 0; k++) {
                    // Add the cost of moving the (i-k)-th robot to the current factory
                    // Note: Cast to long prevents integer overflow during subtraction
                    currentCost += Math.abs((long) robot.get(i - k) - pos);
                    
                    if (dp[i - k][j - 1] != INF) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + currentCost);
                    }
                }
            }
        }
        
        return dp[n][m];
    }
}