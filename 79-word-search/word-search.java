class Solution {
    boolean helper(char[][] board, String word, int i, int j, int n, int m, int k) {
        // Check if k has reached the length of the word
        if (k >= word.length()) return true;
        
        // Check if indices are out of bounds or if the cell has been visited or doesn't match the current character
        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] == '.' || word.charAt(k) != board[i][j]) {
            return false;
        }

        // If the length of the word is 1 and matches the cell, return true
        if (word.length() == 1 && word.charAt(k) == board[i][j]) {
            return true;
        }

        // Mark the current cell as visited
        char temp = board[i][j];
        board[i][j] = '.';

        // Explore in all four directions
        boolean result = 
            helper(board, word, i + 1, j, n, m, k + 1) ||
            helper(board, word, i - 1, j, n, m, k + 1) ||
            helper(board, word, i, j + 1, n, m, k + 1) ||
            helper(board, word, i, j - 1, n, m, k + 1);

        // Restore the cell to its original value
        board[i][j] = temp;

        return result;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        // Iterate through each cell on the board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If the first character of the word matches the current cell, start exploring
                if (word.charAt(0) == board[i][j]) {
                    if (helper(board, word, i, j, n, m, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
