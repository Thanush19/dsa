class Solution {
    class Tuple{
        int i , j, cost;
        Tuple(int i , int j , int cost){
            this.i=i;
            this.j=j;
            this.cost=cost;
        }
    }
    public int minimumEffortPath(int[][] h) {
        int n =h.length;
        int m =h[0].length;
        int[][] dis =new int[n][m];
        for(int[] i : dis){
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
        dis[0][0]=0;
        pq.offer(new Tuple(0,0,0));
        int[] dx= {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        while(!pq.isEmpty()){
            Tuple q = pq.poll();
            int i = q.i;
            int j =q.j;
            int cost = q.cost;
            for(int e = 0; e<4;e++){
                int nr = i+dx[e];
                int nc = j+dy[e];
                if (nr > -1 && nr < n && nc > -1 && nc < m) {
                int newEffort = Math.max(dis[i][j], Math.abs(h[i][j] - h[nr][nc]));
                if (newEffort < dis[nr][nc]) {
                    dis[nr][nc] = newEffort;
                    pq.offer(new Tuple(nr, nc, dis[nr][nc]));
                }
            }

            }
        }
        return dis[n-1][m-1];
    }
}