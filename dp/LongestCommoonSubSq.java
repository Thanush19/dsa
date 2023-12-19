import java.util.Arrays;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return lcs(text1, text1.length(), text2, text2.length(), dp);
    }

    int lcs(String t1, int n1, String t2, int n2, int[][] dp) {
        if (n1 == 0 || n2 == 0) {
            return 0;
        }

        if (dp[n1][n2] != -1) {
            return dp[n1][n2];
        }

        if (t1.charAt(n1 - 1) == t2.charAt(n2 - 1)) {
            return dp[n1][n2] = 1 + lcs(t1, n1 - 1, t2, n2 - 1, dp);
        } else {
            return dp[n1][n2] = Math.max(lcs(t1, n1 - 1, t2, n2, dp), lcs(t1, n1, t2, n2 - 1, dp));
        }
    }
}
