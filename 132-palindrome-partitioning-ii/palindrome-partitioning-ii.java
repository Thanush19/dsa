public class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; j++, i++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        
        int[] minCut = new int[n];
        minCut[0] = 0;
        
        for (int i = 1; i < n; i++) {
            int ans = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                if (dp[j][i]) {
                    ans = Math.min(ans, j - 1 < 0 ? 0 : minCut[j - 1] + 1);
                }
            }
            minCut[i] = ans;
        }
        
        return minCut[n - 1];
    }
}