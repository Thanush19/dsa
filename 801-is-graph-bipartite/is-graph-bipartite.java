import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1); // Initialize colors array with -1 indicating uncolored

        // Iterate over each node in the graph
        for (int i = 0; i < n; i++) {
            // If the current node is uncolored and cannot be colored properly, return false
            if (colors[i] == -1 && !dfs(graph, colors, 0, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] colors, int color, int node) {
        // If the node is already colored, check if the color is as expected
        if (colors[node] != -1) {
            return colors[node] == color;
        }
        
        // Color the node with the given color
        colors[node] = color;

        // Iterate over all neighbors of the current node
        for (int neighbor : graph[node]) {
            // Recursively call DFS with the opposite color
            if (!dfs(graph, colors, 1 - color, neighbor)) {
                return false; // If a conflict is detected, return false
            }
        }
        return true; // If no conflicts are detected, return true
    }
}
