class Solution {
    public int rob(int[] a) {
        int n = a.length;
        if(n==1) return a[0];
        int[] dp = new int[n];
        dp[0]=a[0];
        dp[1]=Math.max(a[0],a[1]);
        for(int i =2 ; i<n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+a[i]);
        }
        return dp[n-1];
        
    }
}