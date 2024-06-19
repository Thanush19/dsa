class Solution {
    int fn(int i ,int prev , int[] a ,int[][] dp){
        if(i==a.length) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int len = fn(i+1,prev,a,dp);
        if(prev==-1 || a[i]>a[prev]){
            len=Math.max(len,1+fn(i+1,i,a,dp));
        }
        
        return dp[i][prev+1]=len;

    }

    public int lengthOfLIS(int[] a) {
        int n = a.length;
        int[][] dp =new int[n][n];
        for(int[] i :dp) Arrays.fill(i,-1);
        return fn(0,-1,a,dp);

    }
}