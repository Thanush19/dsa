import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        int n = graph.length;
        int[] state = new int[n]; // 0: unvisited, 1: visited, 2: safe
        List<List<Integer>> adjList = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            for (int j : graph[i]) {
                adjList.get(i).add(j);
            }
        }

        // Perform DFS from each node
        for (int i = 0; i < n; i++) {
            if (isSafe(i, adjList, state)) {
                result.add(i);
            }
        }

        return result;
    }

    // DFS to determine if the node is eventual safe
    private boolean isSafe(int node, List<List<Integer>> adjList, int[] state) {
        if (state[node] != 0) {
            return state[node] == 2; // If already visited and safe, return true
        }

        state[node] = 1; // Mark node as visited

        // Traverse adjacent nodes
        for (int next : adjList.get(node)) {
            if (!isSafe(next, adjList, state)) {
                return false; // If any adjacent node is not safe, current node is not safe
            }
        }

        state[node] = 2; // Mark node as safe
        return true;
    }
}
