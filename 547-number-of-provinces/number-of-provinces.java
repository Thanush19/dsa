class Solution {
      public int findCircleNum(int[][] isConnected) {
        int V = isConnected[0].length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int vis[] = new int[V];
        int count = 0;
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                count++;
                dfs(i,adjList,vis);
            }
        }
        
        return count;
    }

    public void dfs(int node , ArrayList<ArrayList<Integer>> adj , int vis[]){
        
        vis[node] = 1;
        
        for(int i : adj.get(node)){
            if(vis[i]==0){
                dfs(i,adj,vis);
            }
        }
    }
}