import java.util.PriorityQueue;

class Solution {
    class Tuple {
        double fraction;
        int numerator;
        int denominator;

        Tuple(double fraction, int numerator, int denominator) {
            this.fraction = fraction;
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public int[] kthSmallestPrimeFraction(int[] a, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> Double.compare(x.fraction, y.fraction));

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                pq.offer(new Tuple((double) a[i] / a[j], a[i], a[j]));
            }
        }

        Tuple kthTuple = null;
        while (k > 0) {
            kthTuple = pq.poll();
            k--;
        }

        return new int[]{kthTuple.numerator, kthTuple.denominator};
    }
}
