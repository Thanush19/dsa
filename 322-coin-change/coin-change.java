import java.util.*;

class Solution {
    int fn(int[] coins, int amt, int[][] dp, int idx) {
        if (amt == 0) // Base case: amount becomes 0
            return 0;
        
        if (idx < 0 || amt < 0) // Base case: if amount becomes negative or we run out of coins
            return Integer.MAX_VALUE - 1; // Adjusted to prevent overflow
        
        if (dp[idx][amt] != -1)
            return dp[idx][amt];
        
        int no = fn(coins, amt, dp, idx - 1); // Exclude the current coin
        int yes = 1 + fn(coins, amt - coins[idx], dp, idx); // Include the current coin
        return dp[idx][amt] = Math.min(yes, no);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);
        int result = fn(coins, amount, dp, n - 1);
        return result == Integer.MAX_VALUE - 1 ? -1 : result;
    }
}
