class Solution {
    public boolean searchMatrix(int[][] a, int t) {
        int n = a.length;
        int m= a[0].length;
        int i =0,j= m-1;
        while(i<n && j>-1){
            int temp = a[i][j];
            if(temp==t) return true;
            if(temp>t)j--;
            if(temp<t)i++; 
        }
        return false;
        
    }
}