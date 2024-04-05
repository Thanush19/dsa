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
      dp[n][0] = dp[n][1] = 0;

        int profit = 0;

        // Iterate through the aay in reverse to calculate the maximum profit
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + dp[ind + 1][0], -a[ind] + dp[ind + 1][1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + dp[ind + 1][1], a[ind] + dp[ind + 1][0]);
                }

                dp[ind][buy] = profit;
            }
        }
        return dp[0][0];
    }
}
