import java.util.*;

class Solution {
    class Pair {
        int city, cost;
        Pair(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph.get(from).add(new Pair(to, weight));
            graph.get(to).add(new Pair(from, weight));
        }

        int minReachableCities = n;
        int resultCity = -1;

        for (int i = 0; i < n; i++) {
            int reachableCities = dijkstra(i, n, graph, distanceThreshold);
            if (reachableCities < minReachableCities || 
                (reachableCities == minReachableCities && i > resultCity)) {
                minReachableCities = reachableCities;
                resultCity = i;
            }
        }

        return resultCity;
    }

    private int dijkstra(int start, int n, List<List<Pair>> graph, int distanceThreshold) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Pair(start, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.city;
            int d = current.cost;

            if (d > dist[u]) continue;

            for (Pair neighbor : graph.get(u)) {
                int v = neighbor.city;
                int newDist = d + neighbor.cost;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.add(new Pair(v, newDist));
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i != start && dist[i] <= distanceThreshold) {
                count++;
            }
        }

        return count;
    }
}
