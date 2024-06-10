class Solution {
    int fn(int n , int m , int[][] dp){
        if(n<0 || m<0) return 0;
        if(n==0 && m==0) return 1;
        if(dp[n][m]!=-1) return dp[n][m];

        int up = fn(n-1,m,dp);
        int down = fn(n,m-1,dp);
        return dp[n][m]=up+down;
    }
    public int uniquePaths(int n, int m) {
        int[][] dp = new int[n][m];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
        return fn(n-1,m-1,dp);
        
    }
}