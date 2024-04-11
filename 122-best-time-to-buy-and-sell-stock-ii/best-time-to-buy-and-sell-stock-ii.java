class Solution {
    int fn(int[] a , int idx, int flag,int[][]dp){
        if(a.length==idx) return 0;
        if(dp[idx][flag]!=-1) return dp[idx][flag];
        int pro=0;
        if(flag==0){
            pro = Math.max(-a[idx]+fn(a,idx+1,1,dp),fn(a,idx+1,0,dp));
        }
        else pro= Math.max(a[idx]+fn(a,idx+1,0,dp),fn(a,idx+1,1,dp));
        return dp[idx][flag]= pro;
    }
    public int maxProfit(int[] a) {
        int n= a.length;
        int[][] dp = new int[n+1][2];
        for(int[] i : dp) Arrays.fill(i,-1);
        return fn(a,0,0,dp);
        
    }
}