class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        int i = 0, j = n - 1;
        long ans = 0;
        while (i < k) {
            ans += (happiness[j] - i > 0) ? happiness[j] - i : 0;
            i++;
            j--;
        }
        return ans;
    }
}