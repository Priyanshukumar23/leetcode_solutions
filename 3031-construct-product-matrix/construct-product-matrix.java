class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int size = n * m;
        int MOD = 12345;

        int[] prefix = new int[size];
        int[] suffix = new int[size];

        // Step 1: Prefix
        prefix[0] = 1;
        for (int i = 1; i < size; i++) {
            int val = grid[(i - 1) / m][(i - 1) % m];
            prefix[i] = (int)((long)prefix[i - 1] * val % MOD);
        }

        // Step 2: Suffix
        suffix[size - 1] = 1;
        for (int i = size - 2; i >= 0; i--) {
            int val = grid[(i + 1) / m][(i + 1) % m];
            suffix[i] = (int)((long)suffix[i + 1] * val % MOD);
        }

        // Step 3: Build result matrix
        int[][] result = new int[n][m];

        for (int i = 0; i < size; i++) {
            int r = i / m;
            int c = i % m;
            result[r][c] = (int)((long)prefix[i] * suffix[i] % MOD);
        }

        return result;
    }
}