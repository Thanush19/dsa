class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        
        int buy = prices[0];
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (buy > prices[i]) {
                buy = prices[i];
            } else {
                int currentProfit = prices[i] - buy;
                maxProfit = Math.max(currentProfit, maxProfit);
            }
        }
        
        return maxProfit;
    }
}
