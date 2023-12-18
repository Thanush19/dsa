class Solution {
    class Pair {
        int r;
        int c;
        int t;

        Pair(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cntFrsh = 0;
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else if (grid[i][j] == 1) {
                    cntFrsh++;
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        int tm = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int cnt = 0;

        while (!q.isEmpty()) {
            int r = q.peek().r;
            int c = q.peek().c;
            int t = q.peek().t;
            tm = Math.max(t, tm);

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nc >= 0 && nc < m && nr >= 0 && nr < n && vis[nr][nc] != 2 && grid[nr][nc] == 1) {
                    q.add(new Pair(nr, nc, t + 1));
                    vis[nr][nc] = 2;
                    cnt++;
                }
            }

            q.poll(); 
        }

        if (cntFrsh != cnt) return -1;
        return tm;
    }
}
