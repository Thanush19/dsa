class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        int result = 0;

        for (int i = 0; i < n; i++) {
            HashMap<Double, Integer> mp = new HashMap<>();
            int duplicate = 1;

            for (int j = i + 1; j < n; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    duplicate++;
                    continue;
                }

                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                // Handle vertical lines (dx = 0) and horizontal lines (dy = 0) separately
                double slope = dx == 0 ? Double.POSITIVE_INFINITY : dy == 0 ? 0 : dy / (double) dx;

                mp.put(slope, mp.getOrDefault(slope, 0) + 1);
            }

            result = Math.max(result, duplicate);

            // Add duplicate points to each slope count, including the horizontal line case
            for (int count : mp.values()) {
                result = Math.max(result, count + duplicate);
            }
        }

        return result;
    }
}