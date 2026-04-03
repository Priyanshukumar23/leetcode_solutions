import java.util.Arrays;

class Solution {
    
    // Helper to find the first index where walls[idx] >= target
    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    // Helper to find the first index where walls[idx] > target
    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    // Returns the number of walls strictly within the range [left, right]
    private int count(int[] walls, int left, int right) {
        if (left > right) return 0;
        return upperBound(walls, right) - lowerBound(walls, left);
    }

    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        int m = walls.length;

        // Pair robots with their distances and sort by position
        int[][] robs = new int[n][2];
        for (int i = 0; i < n; i++) {
            robs[i][0] = robots[i];
            robs[i][1] = distance[i];
        }
        Arrays.sort(robs, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Sort walls to enable binary search
        Arrays.sort(walls);

        // Count and isolate walls that are exactly on a robot's position
        int wallsAtRobots = 0;
        int rIdx = 0, wIdx = 0;
        while (rIdx < n && wIdx < m) {
            if (robs[rIdx][0] == walls[wIdx]) {
                wallsAtRobots++;
                rIdx++;
                wIdx++;
            } else if (robs[rIdx][0] < walls[wIdx]) {
                rIdx++;
            } else {
                wIdx++;
            }
        }

        // DP array: dp[i][0] = max walls hit if robot i shoots LEFT
        //           dp[i][1] = max walls hit if robot i shoots RIGHT
        long[][] dp = new long[n][2];
        
        // Base Case: First robot
        dp[0][0] = count(walls, robs[0][0] - robs[0][1], robs[0][0] - 1);
        dp[0][1] = 0; // If it shoots right, it hits 0 walls to its left

        // Process segments between adjacent robots
        for (int i = 1; i < n; i++) {
            int x_prev = robs[i-1][0];
            int d_prev = robs[i-1][1];
            int x_curr = robs[i][0];
            int d_curr = robs[i][1];

            // Define the isolated region exclusively between robot i-1 and robot i
            int A = x_prev + 1;
            int D = x_curr - 1;
            
            // Reach calculations
            int B = Math.min(D, x_prev + d_prev); // Farthest robot i-1 can reach right
            int C = Math.max(A, x_curr - d_curr); // Farthest robot i can reach left

            long cost_L_L = count(walls, C, D); // Only robot i shoots into this segment
            long cost_L_R = 0;                  // Neither shoot into this segment
            long cost_R_R = count(walls, A, B); // Only robot i-1 shoots into this segment
            long cost_R_L = 0;                  // Both shoot into this segment

            if (B >= C) {
                // The ranges overlap, taking out the union of the covered space
                cost_R_L = count(walls, A, D);
            } else {
                // The ranges are disjoint, sum independently
                cost_R_L = count(walls, A, B) + count(walls, C, D);
            }

            // State Transitions
            dp[i][0] = Math.max(dp[i-1][0] + cost_L_L, dp[i-1][1] + cost_R_L);
            dp[i][1] = Math.max(dp[i-1][0] + cost_L_R, dp[i-1][1] + cost_R_R);
        }

        // Resolve the final segment mathematically extending past the last robot
        long maxDp = Math.max(
            dp[n-1][0], 
            dp[n-1][1] + count(walls, robs[n-1][0] + 1, robs[n-1][0] + robs[n-1][1])
        );

        return (int) (maxDp + wallsAtRobots);
    }
}