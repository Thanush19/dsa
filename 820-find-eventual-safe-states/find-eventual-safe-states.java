//https://leetcode.com/problems/find-eventual-safe-states/solutions/3756391/ex-amazon-explains-a-solution-with-a-video-python-javascript-java-and-c

class Solution {
    boolean dfs(int node, int[] vis, List<List<Integer>> adj) {
    if (vis[node] == 2) {
        return true; // If it is 2, it can lead to a terminal node
    }
    if (vis[node] == 1) {
        return false; // If it is 1, it means there's a cycle, so it's not an eventual safe node
    }
    vis[node] = 1; // Mark as visited
    for (int nei : adj.get(node)) {
        if (!dfs(nei, vis, adj)) {
            return false;
        }
    }
    vis[node] = 2; // Mark as a terminal node
    return true;
}

    //if the terminal node has no outbount nodes , it has to be marked as terminal node
    public List<Integer> eventualSafeNodes(int[][] a) {
        int n =a.length;
         List<Integer> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++) adj.add(new ArrayList<>());
        for(int i =0;i<a.length;i++){
            for(int j =0;j<a[i].length;j++){
                adj.get(i).add(a[i][j]);
            }
        }
        int[] vis = new int[n];//2--> term.. node ,1---> visited , 0---> not yet vis
        for(int i =0;i<n;i++){
            if(dfs(i,vis,adj)){
                ans.add(i);
            }

        }
        return ans;
        
    }
}