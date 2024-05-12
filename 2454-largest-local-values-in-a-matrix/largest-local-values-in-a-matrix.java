class Solution {
    public int[][] largestLocal(int[][] a) {
        int n = a.length;
        int[][] ans = new int[n-2][n-2];
        if (n < 3) return ans;
        
        int p = 0, q = 0, z1 = 0, z2 = 0;
        while (p < n - 2) {
            int maxi = -1;
            for (int i = p; i < p + 3; i++) {
                for (int j = q; j < q + 3; j++) {
                    if (maxi < a[i][j]) maxi = a[i][j];
                }
            }
            
            ans[z1][z2] = maxi;
            z2++;
            if (z2 >= n - 2) {
                z1++;
                z2 = 0;
            }
            
            q++;
            if (q >= n - 2) {
                p++;
                q = 0;
            }
        }
        return ans;
    }
}
