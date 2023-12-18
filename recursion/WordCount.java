public class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        if (n == 0) return false;
        int m = board[0].length;
        if (word.length() == 0) return false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (helper(board, word, i, j, n, m, 0)) return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int i, int j, int n, int m, int k) {
        if (k >= word.length()) return true;
        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] == '.' || word.charAt(k) != board[i][j]) {
            return false;
        }
        if (word.length() == 1 && word.charAt(k) == board[i][j]) {
            return true;
        }
        board[i][j] = '.';
        boolean temp = false;
        int[] x = {0, 0, -1, 1};
        int[] y = {-1, 1, 0, 0};
        for (int index = 0; index < 4; index++) {
            temp = temp || helper(board, word, i + x[index], j + y[index], n, m, k + 1);
        }
        board[i][j] = word.charAt(k);
        return temp;
    }
}
