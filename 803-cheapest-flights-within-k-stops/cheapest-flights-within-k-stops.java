class Solution {
    class Pair{
        int node, wt;
        public Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }
    class Pair2{
        int steps, node, dist;
        public Pair2(int steps, int node, int dist){
            this.steps = steps;
            this.node = node;
            this.dist = dist;
        }
    }
    public int findCheapestPrice(int n, int[][] edges, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i< n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e: edges){
            adj.get(e[0]).add(new Pair(e[1], e[2]));
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<Pair2> q = new LinkedList<>();
        q.offer(new Pair2(0, src, 0));
        while(!q.isEmpty()){
            Pair2 front = q.poll();
            if(front.steps> k){
                continue;
            }
            for(Pair e: adj.get(front.node)){
                if(e.wt+ front.dist < dist[e.node] && front.steps<= k){
                    dist[e.node] = e.wt+ front.dist;
                    q.offer(new Pair2(front.steps+1, e.node, dist[e.node]));
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE? -1: dist[dst];
    }
}