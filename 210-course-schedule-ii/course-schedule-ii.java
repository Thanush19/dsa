import java.util.*;

class Solution {
    boolean hasCycle;
    
    void dfs(List<List<Integer>> adj, Stack<Integer> st, boolean[] vis, boolean[] recStack, int node) {
        if (recStack[node]) {
            hasCycle = true;
            return;
        }
        
        if (vis[node])
            return;
        
        vis[node] = true;
        recStack[node] = true;
        
        for (int neighbor : adj.get(node)) {
            dfs(adj, st, vis, recStack, neighbor);
            if (hasCycle) return;
        }
        
        st.push(node);
        recStack[node] = false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int u = prerequisite[1];
            int v = prerequisite[0];
            adj.get(u).add(v);
        }
        
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        hasCycle = false;

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                dfs(adj, st, vis, recStack, i);
                if (hasCycle)
                    return new int[]{};
            }
        }
        
        int[] order = new int[numCourses];
        int idx = 0;
        while (!st.isEmpty()) {
            order[idx++] = st.pop();
        }
        
        return order;
    }
}
