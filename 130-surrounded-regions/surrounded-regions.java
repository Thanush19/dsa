class Solution {
    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public void solve(char[][] board) {
        int m = board.length; // Number of rows
        int n = board[0].length; // Number of columns
        boolean[][] vis = new boolean[m][n]; // Visited array to keep track of visited cells
        int[] dx = {-1, 0, 1, 0}; // Changes in row (up, right, down, left)
        int[] dy = {0, 1, 0, -1}; // Changes in column (up, right, down, left)
        Queue<Pair> q = new LinkedList<>(); // Queue for BFS traversal

        // Loop through the first and last column of the grid
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                vis[i][0] = true;
                q.offer(new Pair(i, 0));
            }
            if (board[i][n - 1] == 'O') {
                vis[i][n - 1] = true;
                q.offer(new Pair(i, n - 1));
            }
        }

        // Loop through the first and last row of the grid
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                vis[0][j] = true;
                q.offer(new Pair(0, j));
            }
            if (board[m - 1][j] == 'O') {
                vis[m - 1][j] = true;
                q.offer(new Pair(m - 1, j));
            }
        }

        // Perform BFS traversal starting from 'O's on the border
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.i;
            int c = p.j;

            // Check neighbors of the current cell
            for (int k = 0; k < 4; k++) {
                int nr = r + dx[k]; // New row
                int nc = c + dy[k]; // New column
                // Check if the neighbor is within the grid boundaries, not visited, and contains 'O'
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc] && board[nr][nc] == 'O') {
                    // Mark the neighbor as visited
                    vis[nr][nc] = true;
                    // Add the neighbor to the queue for further traversal
                    q.offer(new Pair(nr, nc));
                }
            }
        }

        // Flip 'O's inside the grid that are not surrounded by 'X's
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
