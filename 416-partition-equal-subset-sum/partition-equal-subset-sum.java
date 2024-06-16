class Solution {
    boolean fn(int[][] dp,int[] a , int k , int i){
    
        if(k==0) return true;
        if (i < 0 || k < 0) return false; 
        if(dp[i][k]!=-1) return dp[i][k]==1;
        boolean notTake = fn(dp, a, k, i - 1);
        boolean take = false;
        if (a[i] <= k) {
            take = fn(dp, a, k - a[i], i - 1);
        }
        dp[i][k] = (take || notTake) ? 1 : 0;
        return take || notTake;


    }
    public boolean canPartition(int[] a) {
        int sum = Arrays.stream(a).sum();
        int n =a.length;
        if(sum%2!=0) return false;
        else{
            int[][] dp = new int[n][(sum/2)+1];
            int k = sum/2;
            for(int[] i :dp) Arrays.fill(i,-1);
            return fn(dp,a,k,n-1);
        }
        
    }
}