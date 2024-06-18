class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] diffProfit = new int[profit.length][2];
        for (int i = 0; i < profit.length; i++) {
            diffProfit[i] = new int[] { difficulty[i], profit[i] };
        }
        Arrays.sort(diffProfit, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);
        int maxProfit = 0;
        for (int[] job: diffProfit) {
            maxProfit = Math.max(maxProfit, job[1]);
            job[1] = maxProfit;
        }
        int l = -1;
        int total = 0;
        for (int current: worker) {
            int r = worker.length;
            while (l + 1 < r) {
                int m = (r + l) >> 1;
                if (diffProfit[m][0] <= current) {
                    l = m;
                } else {
                    r = m;
                }
            }
            if (l >= 0) {
                total += diffProfit[l][1];
            }             
        }
        return total;
    }
}