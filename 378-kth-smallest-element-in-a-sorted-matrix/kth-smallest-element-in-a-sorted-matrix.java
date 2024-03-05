class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] arr = new int[matrix.length * matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                arr[(i * matrix.length) + j] = matrix[i][j];
            }
        }
        Arrays.sort(arr);
        if (arr.length < k-1) {
            return arr[0];
        }
        return arr[k-1];
    }
}