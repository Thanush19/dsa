class Solution {
    public int[][] generateMatrix(int n) {
        int count = 1;
        int[][] ans = new int[n][n];
        int top = 0, bottom = n-1, right = n-1, left = 0;
        while(top <= bottom && left <= right){

            // TopLeft --> TopRight
            for(int i = left; i <= right; i++)
                ans[top][i] = count++;
            top++;

            // TopRight --> BottomRight
            for(int i = top; i <= bottom; i++)
                ans[i][right] = count++;
            right--;

            // BottomRight --> BottomLeft
            for(int i = right; i >= left; i--)
                ans[bottom][i] = count++;
            bottom--;

            // BottomLeft --> TopLeft
            for(int i = bottom; i >= top; i--)
                ans[i][left] = count++;
            left++;
        }
        return ans;
    }
}