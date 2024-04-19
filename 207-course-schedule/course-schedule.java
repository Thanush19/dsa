import java.util.*;

class Solution {
    boolean dfs(List<List<Integer>> adj, boolean[] vis, boolean[] path, int par) {
        vis[par] = true;
        path[par] = true;
        
        for (int chi : adj.get(par)) {
            if (!vis[chi]) {
                if (!dfs(adj, vis, path, chi)) return false;
            } else if (path[chi]) {
                return false;
            }
        }
        
        path[par] = false; // Reset the path for the current node
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] vis = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] prerequisite : prerequisites) {
            int u = prerequisite[1];
            int v = prerequisite[0];
            adj.get(u).add(v);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (!dfs(adj, vis, path, i)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
