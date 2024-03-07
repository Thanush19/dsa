class Solution {
    class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        int originalColor = image[sr][sc]; // Get the original color
        if (originalColor == color) return image; // If original color matches new color, no need to flood fill
        image[sr][sc] = color;
        vis[sr][sc] = true;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr, sc));
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            int r = temp.r;
            int c = temp.c;
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && image[nr][nc] == originalColor) {
                    image[nr][nc] = color;
                    vis[nr][nc] = true;
                    q.offer(new Pair(nr, nc));
                }
            }
        }
        return image;
    }
}
