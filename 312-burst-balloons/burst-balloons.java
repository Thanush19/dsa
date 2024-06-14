class Solution {
    int [][] dp ;
    public int maxCoins(int[] nums) {
        dp = new int[nums.length][nums.length];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        return solve(nums,0,nums.length-1);
    }
    public int solve(int [] nums,int i,int j)
    {
        if(i>j) return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int max = 0;
        for(int k = i;k<=j;k++)
        {
            int temp = solve(nums,i,k-1) + solve(nums,k+1,j)+nums[k]*(i-1<0?1:nums[i-1])*(j+1>=nums.length?1:nums[j+1]);
            max = Math.max(max,temp);
        }
        return dp[i][j] = max;
    }
}