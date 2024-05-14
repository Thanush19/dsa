class Solution {
    int fn(int i , int j , boolean[][] vis,int[][] a){
         int[] dx = {-1,0,1,0};
         int[] dy = {0,1,0,-1};
         vis[i][j]=true;
         int res =0;
         for(int k = 0;k<4;k++){
            int ni = i+dx[k];
            int nj = j+dy[k];
            if(ni>-1 && ni<a.length && nj>-1 && nj<a[0].length && a[ni][nj]!=0 && !vis[ni][nj]){
              res = Math.max( fn(ni,nj,vis,a),res);
            }
         }
        vis[i][j]=false;
        return res+a[i][j];
    }

    public int getMaximumGold(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        boolean vis[][] = new boolean[n][m];
        int maxi =Integer.MIN_VALUE;
       
        for(int i  = 0;i<n;i++){
            for(int j =0 ; j<m;j++){
                maxi = Math.max(fn(i,j,vis,a),maxi);

            }
        }
        return maxi;

        
    }
}