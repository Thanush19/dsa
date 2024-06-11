
class Solution {
    int fn(int[][] a, int n, int m, int i, int j, int[][] dp) {
        if (i == 0 && j == 0) return a[i][j];
        if (i < 0 || j < 0) return Integer.MAX_VALUE;
        if (dp[i][j] != -1) return dp[i][j];

        int up = i > 0 ? fn(a, n, m, i - 1, j, dp) : Integer.MAX_VALUE;
        int left = j > 0 ? fn(a, n, m, i, j - 1, dp) : Integer.MAX_VALUE;

        dp[i][j] = a[i][j] + Math.min(up, left);
        return dp[i][j];
    }

    public int minPathSum(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return fn(a, n, m, n - 1, m - 1, dp);
    }
}