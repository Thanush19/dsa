class tuple{
    int first , second , third;
    tuple(int _f , int _s, int _t){
        this.first = _f;
        this.second = _s;
        this.third = _t;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // Edge case 1 : no possbile path
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        // Edge case 2 
        if(n == 1 && grid[n-1][n-1] == 0) return 1;

        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(1  , 0 , 0));
        int[][] darray = new int[n][m];
        for(int i = 0; i < n  ;i++){
            for(int j = 0 ; j < m ; j++){
                darray[i][j] = (int)(1e9);
            }
        }
        darray[0][0] = 0;

        int[] dr = {1, 1, -1, -1, -1, 0, 1, 0};
        int[] dc = {1, -1, 1, -1, 0, -1, 0, 1};
        while(!q.isEmpty()){
            tuple it = q.peek();
            int dist = it.first;
            int row = it.second;
            int col = it.third;
            q.remove();
            for(int i =0 ; i < 8 ; i++){
                int nrow = row + dr[i];
                int ncol = col + dc[i];
                if(nrow >= 0 && nrow < n  && ncol >= 0 && 
                ncol < m && grid[nrow][ncol] == 0  
                && dist + 1 < darray[nrow][ncol]){
                    if(nrow == n-1 && ncol == n-1) return dist + 1;
                    darray[nrow][ncol] = dist + 1;
                    q.add(new tuple (dist + 1 , nrow , ncol));

                }
            }
        }
        return -1;
    }
}