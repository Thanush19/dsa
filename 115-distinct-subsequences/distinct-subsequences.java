class Solution {
    int fn(String s, String t, int i, int j, int[][] dp) {
        // If we reach the end of t, it means we found a valid subsequence
        if (j < 0) return 1;
        // If we reach the end of s but not the end of t, return 0
        if (i < 0) return 0;
        // If the value is already computed, return it
        if (dp[i][j] != -1) return dp[i][j];
        
        int ans = 0;
        // If the characters match, we can either include or exclude the character
        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = fn(s, t, i - 1, j - 1, dp) + fn(s, t, i - 1, j, dp);
        } else {
            // If the characters don't match, we can only exclude the character from s
            dp[i][j] = fn(s, t, i - 1, j, dp);
        }
        // Return the computed value
        return dp[i][j];
    }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        // Create a memoization table
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        // Start recursion from the end of both strings
        return fn(s, t, n - 1, m - 1, dp);
    }
}
