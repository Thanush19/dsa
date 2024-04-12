import java.util.Arrays;

class Solution {
    public int findNumberOfLIS(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(a[i] > a[j] && dp[i] <= dp[j] + 1) {
                    if(dp[i] == dp[j] + 1)
                        cnt[i] += cnt[j];
                    else {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
        }
        
        int maxLen = Arrays.stream(dp).max().orElse(0);
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(dp[i] == maxLen)
                ans += cnt[i];
        }
        
        return ans;
    }
}
