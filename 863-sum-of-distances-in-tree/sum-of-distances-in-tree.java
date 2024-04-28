class Solution {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
       int[] ans = new int[N];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] count = new int[N];
        int[] sum = new int[N];
        dfs(graph, count, sum, 0, -1);
        dfs2(graph, count, sum, 0, -1);
        return sum;
    }

    private void dfs(List<List<Integer>> graph, int[] count, int[] sum, int root, int pre) {
        for (int node : graph.get(root)) {
            if (node == pre)
                continue;
            dfs(graph, count, sum, node, root);
            count[root] += count[node];
            sum[root] += sum[node] + count[node];
        }
        count[root]++;
    }

    private void dfs2(List<List<Integer>> graph, int[] count, int[] sum, int root, int pre) {
        for (int node : graph.get(root)) {
            if (node == pre)
                continue;
            sum[node] = sum[root] - count[node] + count.length - count[node];
            dfs2(graph, count, sum, node, root);
        }
    }
}