class Solution {
    int fn(int[] a , int k ,int idx, int flag, int cap ,   int[][][] dp){
        if(idx==a.length || cap ==k) return 0;
        if(dp[idx][flag][cap]!=-1) return dp[idx][flag][cap];
        int pro=0;
        if(flag==0){
            pro = Math.max(-a[idx]+fn(a,k,idx+1,1,cap,dp),fn(a,k,idx+1,0,cap,dp));
        }
        else{
            pro= Math.max(a[idx]+fn(a,k,idx+1,0,cap+1,dp),fn(a,k,idx+1,1,cap,dp));
        }
        return dp[idx][flag][cap]=pro;
    }
    public int maxProfit(int k, int[] a) {
        int n  = a.length;
        int[][][] dp = new int[n+1][2][k+1];
        for(int i = 0 ; i<= n ; i++){
            for(int j = 0; j<2 ; j++){
                for(int z = 0 ; z<=k;z++){
                    dp[i][j][z]=-1;
                }
            }
        }
        return fn(a,k,0,0,0,dp);
        
    }
}