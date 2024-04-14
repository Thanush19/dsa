class Solution {
    class Pair {
        int i;
        int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int t = 0;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int freshCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2 && !vis[i][j]) {
                    q.offer(new Pair(i, j));
                    vis[i][j] = true;
                }
                if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        while (!q.isEmpty() && freshCount > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                int r = p.i;
                int c = p.j;
                for (int k = 0; k < 4; k++) {
                    int nr = r + dx[k];
                    int nc = c + dy[k];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1 && !vis[nr][nc]) {
                        q.offer(new Pair(nr, nc));
                        vis[nr][nc] = true;
                        grid[nr][nc] = 2; // Marking the orange as rotten
                        freshCount--; // Decrementing the count of fresh oranges
                    }
                }
            }
            t++; // Incrementing time after processing each level
        }

        return freshCount == 0 ? t : -1;
    }
}
