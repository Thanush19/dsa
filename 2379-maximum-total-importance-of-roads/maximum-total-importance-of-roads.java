import java.util.PriorityQueue;

class Solution {
    static class Pair {
        int node, cost;
        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public long maximumImportance(int n, int[][] a) {
        // Calculate the degree of each node
        int[] ind = new int[n];
        for (int i = 0; i < a.length; i++) {
            ind[a[i][0]]++;
            ind[a[i][1]]++;
        }

        // Use a priority queue to sort nodes based on their degrees and node index
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, b) -> {
            if (x.cost == b.cost) {
                return x.node - b.node;
            }
            return x.cost - b.cost;
        });

        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(i, ind[i]));
        }

        // Assign importance based on sorted order
        int[] imp = new int[n];
        int cnt = 1;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            imp[p.node] = cnt++;
        }

        long ans=0;
        for(int i =0;i<a.length;i++){
            ans+=(imp[a[i][0]]+imp[a[i][1]]);
        }
        return ans;

    }

    
}
