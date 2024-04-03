class Solution {
    public boolean exist(char[][] a, String w) {
        int n   = a.length;
        int m = a[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0 ; j<m;j++){
                if(w.charAt(0)== a[i][j]){
                    if(dfs(i,j,a,w,0,vis)) return true;
                
                }
                
            }
        }
        return false;  
    }
    boolean dfs(int n , int m , char[][] a , String w, int idx,boolean[][] vis){
        if(idx==w.length()){
            return true;
        }
        if( n < 0 || n >= a.length || m < 0 || m >= a[0].length || vis[n][m] || a[n][m] != w.charAt(idx)){
            return false;
        }
        vis[n][m] = true;
        boolean ans =  dfs(n-1, m,a,w,idx+1,vis ) ||  dfs(n, m+1,a,w,idx+1,vis ) || dfs(n+1, m,a,w,idx+1,vis ) || dfs(n, m-1,a,w,idx+1 ,vis);

                       //up                            //right                       //bottom                                 //left
        vis[n][m] = false;

  
        return ans;

    }
}