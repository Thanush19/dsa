import java.util.*;

class Solution {
    boolean bfs(List<List<Integer>> adj, int[] col, int node) {
        col[node] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            int p = q.poll();
            for (int i : adj.get(p)) {
                if (col[i] == -1) {
                    col[i] = 1 - col[p];
                    q.offer(i);
                } else if (col[i] == col[p]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean possibleBipartition(int n, int[][] a) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : a) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] col = new int[n + 1];
        Arrays.fill(col, -1);
        for (int i = 1; i <= n; i++) {
            if (col[i] == -1 && !bfs(adj, col, i)) {
                return false;
            }
        }
        return true;
    }
}
