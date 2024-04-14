class Solution {
    class Pair{
        int i;
        int j ;
        Pair(int i , int j){
            this.i=i;
            this.j=j;
        }

        
    }
    public int maxAreaOfIsland(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair>  q = new LinkedList<>();
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int maxi = Integer.MIN_VALUE;

        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(a[i][j]==1 && !vis[i][j]){
                    int cnt=0;
                    q.offer(new Pair(i,j));
                    vis[i][j]=true;
                    while(!q.isEmpty()){
                        Pair p = q.poll();
                        int r = p.i;
                        int c = p.j;

                        for(int k =0;k<4;k++){
                            int nr = r+dx[k];
                            int nc = c+dy[k]; // Corrected calculation for nc
                            if(nr>-1 && nr<n && nc>-1 && nc<m && a[nr][nc]==1 && !vis[nr][nc]){
                                cnt++;
                                q.offer(new Pair(nr,nc));
                                vis[nr][nc]=true;
                            }
                        }

                    }
                    maxi = Math.max(cnt,maxi);

                }


            }
        }
return maxi == Integer.MIN_VALUE ? 0 : maxi + 1;
        
        
    }
}
