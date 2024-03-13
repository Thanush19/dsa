class Solution {
    int fn(int m, int n, int[][] grid, int[][] dp) {
        if (m == 0 && n == 0) {
            return grid[0][0];
        }
        if (dp[m][n] != -1) return dp[m][n];
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if (m > 0) up = fn(m - 1, n, grid, dp);
        if (n > 0) left = fn(m, n - 1, grid, dp);
        return dp[m][n] = grid[m][n] + Math.min(up, left);
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1); // Initialize dp array with -1
        }
        dp[0][0] = grid[0][0]; // Initialize starting point
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0]; // Initialize first column
        }
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j]; // Initialize first row
        }
        return fn(n - 1, m - 1, grid, dp);
    }
}
