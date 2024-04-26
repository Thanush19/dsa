class Solution {
public int min(int i,int last,int m,int grid[][],int dp[][])
{
if(i<0)
return 0;

if(dp[i][last]!=-1)
  return dp[i][last];
 if(i == 0)
 {
   int min=Integer.MAX_VALUE;
   for(int j=0; j < m ; j++)
   {
     if(j!=last)
     {
       min=Math.min(min,grid[0][j]);
     }
   }
   return dp[i][last]=min;
 }
int min=Integer.MAX_VALUE;
for(int j=0;j<m;j++)
{
    if(j!=last)
    {
      int acti=grid[i][j]+min(i-1,j,m,grid,dp);
      min=Math.min(min,acti);
    }
  }

return dp[i][last]=min;
}
public int minFallingPathSum(int[][] grid) 
{
  int n=grid.length;
  int m=grid[0].length;
 int dp[][]=new int[n][m+1];
  for(int row[]:dp)
    Arrays.fill(row,-1);
   return min(n - 1, m,m, grid,dp);
}
}