class Solution {
    int fn(int n, int m, int[][] dp, int[][] a) {
        if (n < 0 || m < 0 || a[n][m] == 1) {
            return 0;
        }
        if (n == 0 && m == 0) {
            return 1;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        int left = fn(n, m - 1, dp, a);
        int right = fn(n - 1, m, dp, a);
        return dp[n][m] = left + right;
    }

    public int uniquePathsWithObstacles(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        if (n == 1 && m == 1 && a[0][0] != 1) {
            return 1;
        }
        if (n == 1 && m == 1 && a[0][0] == 1) {
            return 0;
        }
        int[][] dp = new int[n][m];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return fn(n - 1, m - 1, dp, a);
    }
}
