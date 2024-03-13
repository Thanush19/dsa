class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        
        int[][] dp=new int[m][n];
        
        for(int i=m-1;i>=0;i--){
            
            for(int j=n-1;j>=0;j--){
                
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }
                else if(i==m-1 && j==n-1) {
                    dp[i][j]=1;
                }else{

                    int up=0;
                    int left=0;
                    
                    if(j+1<n){
                       up=dp[i][j+1]; 
                    }
                    
                    if(i+1<m){
                         left=dp[i+1][j];
                    }
                   
                    
                    dp[i][j]=up+left;
                }
            }
        }
        
        return dp[0][0];
        
    }
    
    
}