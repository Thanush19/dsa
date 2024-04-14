class Solution {
    class Pair{
        int i ;
        int j ;
        Pair(int i , int j){
            this.i= i;
            this.j=j;
        }
    }
    public int numIslands(char[][] a) {
        int n = a.length;
        int m = a[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        int[] dx = {-1,0,1,0};
        int [] dy = {0,1,0,-1};
        int cnt=0;
        for(int i =0;i<n;i++){
            for(int j = 0 ; j<m;j++){
                if(a[i][j]=='1' && !vis[i][j]){
                    q.offer(new Pair(i,j));
                    vis[i][j] = true;
                    cnt++;
                    while(!q.isEmpty()){
                        Pair p = q.poll();
                        int r = p.i;
                        int c = p.j;
                        
                        for(int k = 0; k<4;k++){
                            int nr = dx[k]+r;
                            int nc = dy[k]+c;
                            if(nr>-1 && nr< n && nc>-1 && nc<m && !vis[nr][nc]&& a[nr][nc] == '1'){
                                vis[nr][nc]=true;
                                q.offer(new Pair(nr,nc));

                            }
                        }
                    }
                }
            }
        }
        return cnt;

        
    }
}