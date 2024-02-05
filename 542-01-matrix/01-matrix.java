class Node{
    int first;
    int second;
    int third;
    Node(int _first, int _second, int _third){
        this.first=_first;
        this.second=_second;
        this.third=_third;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int [][]vis=new int[n][m];
        int [][]dist=new int[n][m];
        Queue<Node> q=new LinkedList<Node>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Node(i,j,0));
                    vis[i][j]=1;
                }
            }
        }

        int drow[]={-1,0,1,0};
        int dcol[]={0,-1,0,1};

        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            int steps=q.peek().third;
            q.remove();
            dist[r][c]=steps;
            for(int i=0;i<4;i++){
                int nrow=r+drow[i];
                int ncol=c+dcol[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    q.add(new Node(nrow,ncol,steps+1));
                }
            }
        }
        return dist;
    }
}