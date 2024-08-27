import java.util.*;

class Solution {
    class T{
        int node;
        double prob;
        T(int _node , double _prob){
            node = _node;
            prob = _prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<T>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new T(edges[i][1], succProb[i]));
            adj.get(edges[i][1]).add(new T(edges[i][0], succProb[i]));
        }

        double[] prob = new double[n];
        Arrays.fill(prob, 0.0);
        prob[start] = 1.0;

        PriorityQueue<T> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.offer(new T(start, 1.0));

        while (!pq.isEmpty()) {
            T current = pq.poll();
            int node = current.node;
            double currProb = current.prob;

            if (node == end) return currProb;

            for (T neighbor : adj.get(node)) {
                if (prob[neighbor.node] < currProb * neighbor.prob) {
                    prob[neighbor.node] = currProb * neighbor.prob;
                    pq.offer(new T(neighbor.node, prob[neighbor.node]));
                }
            }
        }

        return 0.0;
    }
}
