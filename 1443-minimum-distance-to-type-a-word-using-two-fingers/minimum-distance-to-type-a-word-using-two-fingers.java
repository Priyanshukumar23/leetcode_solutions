class Solution {
    public int minimumDistance(String word) {
        int[] dp = new int[26];
        int totalDist = 0;
        int maxSaved = 0;
        
        // Iterate through consecutive character pairs
        for (int i = 0; i < word.length() - 1; i++) {
            int b = word.charAt(i) - 'A';
            int c = word.charAt(i + 1) - 'A';
            
            // Create a copy to hold our new states for this step
            int[] nextDp = dp.clone();
            
            // Try using the second finger from every possible resting character 'a'
            for (int a = 0; a < 26; a++) {
                // If the second finger moves from 'a' to 'c', our newly resting finger is 'b'.
                // We add our new savings: dist(b, c) - dist(a, c)
                nextDp[b] = Math.max(nextDp[b], dp[a] + getDist(b, c) - getDist(a, c));
            }
            
            dp = nextDp;
            maxSaved = Math.max(maxSaved, dp[b]);
            totalDist += getDist(b, c);
        }
        
        // The minimum cost is the one-finger cost minus the optimal savings
        return totalDist - maxSaved;
    }
    
    // Helper function to calculate Manhattan distance on the 6-column grid
    private int getDist(int char1, int char2) {
        int x1 = char1 / 6, y1 = char1 % 6;
        int x2 = char2 / 6, y2 = char2 % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}