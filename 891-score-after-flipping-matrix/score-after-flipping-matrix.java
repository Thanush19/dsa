import java.util.*;

class Solution {
    public int matrixScore(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int r = 0; r < rows; r++) {
            if (grid[r][0] == 0) {
                for (int c = 0; c < cols; c++) {
                    if (grid[r][c] == 0) {
                        grid[r][c] = 1;
                    } else {
                        grid[r][c] = 0;
                    }
                }
            }
        }
        
        Map<Integer, Integer> counts = new HashMap<>();
        for (int c = 1; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                if (grid[r][c] == 0) {
                    counts.put(c, counts.getOrDefault(c, 0) + 1);
                }
            }
        }
        
        int res = rows * (1 << (cols - 1));
        for (int c = 1; c < cols; c++) {
            res += Math.max(counts.getOrDefault(c, 0), rows - counts.getOrDefault(c, 0)) * (1 << (cols - c - 1));
        }
        
        return res;
    }
}