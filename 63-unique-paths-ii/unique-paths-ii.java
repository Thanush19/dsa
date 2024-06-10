class Solution {
    int fn(int n , int m , int[][] a , int [][] dp){
        if(n==0 && m==0) return 1;
        if(n<0 || m<0 ) return 0;


        if(a[n][m]==1) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        int up = fn(n-1,m, a, dp);
        int down = fn(n,m-1, a, dp);
        return dp[n][m]=up+down;


    }
    public int uniquePathsWithObstacles(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] dp = new int[n][m];
        // for(int[] i  : dp)Arrays.fill(i,-1);
        // return fn(n-1,m-1,a,dp);
                if (a[0][0] == 1) return 0;

        dp[0][0]=1;
       for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Skip the starting cell as it's already initialized
                if (i == 0 && j == 0) continue;
                
                // If there's an obstacle, set dp[i][j] to 0
                if (a[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    // Sum of the ways to reach the cell from the top and left cells
                    if (i > 0) dp[i][j] += dp[i - 1][j];
                    if (j > 0) dp[i][j] += dp[i][j - 1];
                }
            }
        }
        
        return dp[n - 1][m - 1];

        
    }
}