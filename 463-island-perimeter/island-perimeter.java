class Solution {
    public int islandPerimeter(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int perimeter = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1) {
                    perimeter += 4; // Add 4 for each land cell

                    // Check neighboring cells
                    if (i - 1 >= 0 && a[i - 1][j] == 1) // Up
                        perimeter -= 1;
                    if (j + 1 < m && a[i][j + 1] == 1) // Right
                        perimeter -= 1;
                    if (i + 1 < n && a[i + 1][j] == 1) // Down
                        perimeter -= 1;
                    if (j - 1 >= 0 && a[i][j - 1] == 1) // Left
                        perimeter -= 1;
                }
            }
        }

        return perimeter;
    }
}
