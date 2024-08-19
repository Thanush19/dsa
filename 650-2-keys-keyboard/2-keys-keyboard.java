class Solution {
    public int minSteps(int n) {
 int[] dp = new int[n + 1];
        
        // Initialize the DP array
        for (int i = 2; i <= n; i++) {
            dp[i] = i;  // Maximum operations: i Paste operations
            
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }
        }
        
        return dp[n];        
    }
}