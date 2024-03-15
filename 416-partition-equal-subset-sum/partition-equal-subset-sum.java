class Solution {
    boolean fn(int[]a , int[][] dp ,int i , int tar){
        if(i==0) return a[i]==tar;
        if(tar==0) return true;
        if(dp[i][tar]!=-1) return dp[i][tar]==1?true:false;
        boolean take=false;
        if(a[i]<=tar) take = fn(a,dp,i-1,tar-a[i]);
        boolean not = fn(a,dp,i-1,tar);
        dp[i][tar]= take||not ? 1:0;
        return take||not;
        
    }
    public boolean canPartition(int[] nums) {
        int sum =  Arrays.stream(nums).sum();
        if(sum%2!=0) return false;
        int[][] dp = new int[nums.length][(sum/2)+1];
        for(int[] i : dp) Arrays.fill(i,-1);
        return fn(nums,dp,nums.length-1,sum/2);
        
        
    }
}