import java.util.*;

class Solution {
    class Pair {
        int nxt;
        int cost;
        
        Pair(int nxt, int cost) {
            this.nxt = nxt;
            this.cost = cost;
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        // Create adjacency list to represent the graph
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            adj.get(u - 1).add(new int[]{v - 1, cost});
        }
        
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k - 1] = 0; // Distance from source to itself is 0
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Pair(k - 1, 0)); // Add source node to the priority queue
        
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int nxt = p.nxt;
            int cost = p.cost;
            
            for (int[] neighbor : adj.get(nxt)) {
                int nei = neighbor[0];
                int cst = neighbor[1];
                int newcost = cst + cost;
                
                if (newcost < dis[nei]) {
                    dis[nei] = newcost;
                    pq.offer(new Pair(nei, newcost));
                }
            }
        }
        
        int maxTime = Arrays.stream(dis).max().getAsInt();
        
        return maxTime == Integer.MAX_VALUE ? -1 : maxTime;
    }
}
