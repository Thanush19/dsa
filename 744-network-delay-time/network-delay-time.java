class Solution {
    class Pair{
        int to, c;
        Pair(int to, int cost){
            this.to = to;
            this.c = cost;
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] time : times) {
            adj.get(time[0] - 1).add(new Pair(time[1] - 1, time[2])); // Adjust indices to start from 0
        }
        
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k - 1] = 0; // Adjust index to start from 0
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(k - 1, 0)); // Adjust index to start from 0
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int node = p.to;
            int c = p.c;
            for (Pair m : adj.get(node)) {
                if (c + m.c < dis[m.to]) {
                    dis[m.to] = c + m.c;
                    q.offer(new Pair(m.to, dis[m.to]));
                }
            }
        }
        
        int maxTime = Arrays.stream(dis).max().getAsInt();
        return maxTime == Integer.MAX_VALUE ? -1 : maxTime;
    }
}
