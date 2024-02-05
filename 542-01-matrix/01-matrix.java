class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Deque<int[]> q = new ArrayDeque<>();
        int length = 0;
        int[] dirX = {1, -1, 0, 0}, dirY = {0, 0, 1, -1};

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    q.addFirst(new int[] {i,j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int levelSize = q.size();
            length++;
            while (levelSize-- > 0) {
                int[] pos = q.removeLast();
                for (int i = 0; i < 4; i++) {
                    int x = pos[0] + dirX[i];
                    int y = pos[1] + dirY[i];
                    if (checkBounds(mat.length, mat[0].length, x, y) && mat[x][y] < 0) {
                        mat[x][y] = length;
                        q.addFirst(new int[] {x,y});
                    }
                }
            }
        }

        return mat;
    }

    private boolean checkBounds(int r, int c, int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }
}