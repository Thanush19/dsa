class Solution {
    int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0)
                    dp[i][j] += dp[i - 1][j]; // Add the value from above cell
                if (j > 0)
                    dp[i][j] += dp[i][j - 1]; // Add the value from left cell
            }
        }

        return dp[m - 1][n - 1];
    }
}
