class Solution {

    public long minimumCost(String source, String target,
                            String[] original, String[] changed, int[] cost) {

        int n = source.length();

        // Step 1: Map every unique string to an index
        Map<String, Integer> id = new HashMap<>();
        int idx = 0;

        for (String s : original) {
            if (!id.containsKey(s)) id.put(s, idx++);
        }
        for (String s : changed) {
            if (!id.containsKey(s)) id.put(s, idx++);
        }

        int m = idx;
        long INF = (long) 1e18;

        // Step 2: Floyd–Warshall setup
        long[][] dist = new long[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int u = id.get(original[i]);
            int v = id.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        // Floyd–Warshall
        for (int k = 0; k < m; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Step 3: DP
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {

            // Case 1: characters already match
            if (source.charAt(i) == target.charAt(i)) {
                dp[i] = dp[i + 1];
            }

            // Case 2: try substring conversions
            for (String s : id.keySet()) {
                int len = s.length();
                if (i + len > n) continue;

                if (source.substring(i, i + len).equals(s)) {
                    for (String t : id.keySet()) {
                        if (t.length() != len) continue;
                        if (!target.substring(i, i + len).equals(t)) continue;

                        long c = dist[id.get(s)][id.get(t)];
                        if (c < INF) {
                            dp[i] = Math.min(dp[i], c + dp[i + len]);
                        }
                    }
                }
            }
        }

        return dp[0] == INF ? -1 : dp[0];
    }
}
