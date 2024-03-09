import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totSum = 0;
        for (int i = 0; i < n; i++) {
            totSum += nums[i]; // Corrected variable name from 'arr' to 'nums'
        }

        // If the total sum is odd, it cannot be partitioned into equal subsets
        if (totSum % 2 == 1)
            return false;
        else {
            // Calculate the target sum for each subset
            int k = totSum / 2;
            // Create a memoization table
            int dp[][] = new int[n][k + 1];
            for (int row[] : dp)
                Arrays.fill(row, -1);
            // Call the helper function to check if a valid subset exists
            return subsetSumUtil(n - 1, k, nums, dp); // Corrected variable name from 'arr' to 'nums'
        }
    }

    static boolean subsetSumUtil(int ind, int target, int nums[], int[][] dp) {
        // If the target sum is 0, we have found a valid subset
        if (target == 0)
            return true;

        // If we have processed all elements in the array
        if (ind == 0)
            return nums[0] == target;

        // If this subproblem has already been solved, return the result
        if (dp[ind][target] != -1)
            return dp[ind][target] == 0 ? false : true;

        // Try not taking the current element into the subset
        boolean notTaken = subsetSumUtil(ind - 1, target, nums, dp);

        // Try taking the current element into the subset if it doesn't exceed the target
        boolean taken = false;
        if (nums[ind] <= target)
            taken = subsetSumUtil(ind - 1, target - nums[ind], nums, dp);

        // Memoize the result and return true if either choice results in a valid subset
        dp[ind][target] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }
}