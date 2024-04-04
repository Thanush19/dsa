class Solution {
    boolean isStar(String s, int idx) {
        for (int i = 0; i <= idx; i++) {
            if (s.charAt(i) != '*') return false;
        }
        return true;
    }

    int fn(String s, String p, int i, int j, int[][] dp) {
        if (j < 0) return i < 0 ? 1 : 0; // Check if both indices are out of bounds
        if (i < 0) return isStar(p, j) ? 1 : 0; // Check if i is out of bounds and p is a star pattern
        if (dp[i][j] != -1) return dp[i][j]; // Return memoized result

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
            return dp[i][j] = fn(s, p, i - 1, j - 1, dp);
        else if (p.charAt(j) == '*')
            return dp[i][j] = (fn(s, p, i - 1, j, dp) == 1 || fn(s, p, i, j - 1, dp) == 1) ? 1 : 0;

        return dp[i][j];
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);
        return fn(s, p, n - 1, m - 1, dp) == 1;
    }
}
