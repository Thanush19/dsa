class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        int cnt =0;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    q.offer(new int[]{i,j});
                    cnt++;
                     while(!q.isEmpty()){
                        int[] aa = q.poll();
                        int  ii =aa[0];
                        int  jj =aa[1];
                        vis[ii][jj]=true;
                        for(int k =0;k<4;k++){
                            int nr = ii+dx[k];
                            int nc = jj+dy[k];
                             if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && grid[nr][nc] == '1') {
                                q.offer(new int[]{nr, nc});
                                vis[nr][nc] = true;
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
