class Solution {
    int fn(int[] a, int idx, int flag, int[][] dp) {
        if (idx == a.length) return 0;
        if (dp[idx][flag] != -1) return dp[idx][flag];
        if (flag == 0) {
            // If we don't hold the stock, we can either buy it or move to the next day without any action
            dp[idx][flag] = Math.max(-a[idx] + fn(a, idx + 1, 1, dp), fn(a, idx + 1, 0, dp));
        } else {
            // If we hold the stock, we can either sell it or move to the next day without any action
            dp[idx][flag] = Math.max(a[idx] + fn(a, idx + 1, 0, dp), fn(a, idx + 1, 1, dp));
        }
        return dp[idx][flag];
    }
    
    public int maxProfit(int[] a) {
        int n = a.length;
        int[][] dp = new int[n + 1][2];
        for (int[] i : dp) Arrays.fill(i, -1);
        return fn(a, 0, 0, dp);
    }
}
