import java.util.*;

class Solution {
    int fn(List<List<Integer>> triangle, int[][] dp, int i, int j) {
        if (i == triangle.size() - 1) {
            return dp[i][j] = triangle.get(i).get(j);
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int down = fn(triangle, dp, i + 1, j);
        int dia = fn(triangle, dp, i + 1, j + 1); 
        return dp[i][j] = triangle.get(i).get(j) + Math.min(down, dia);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return fn(triangle, dp, 0, 0);
    }
}
