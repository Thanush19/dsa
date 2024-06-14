class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return memo(n,s,0,dp);
    }
    public static int memo(int n, String s, int i, int dp[]){
        if(i==n) return 1;
        if(s.charAt(i)=='0') return 0;
        if(dp[i]!=-1) return dp[i];
        int cnt = memo(n,s,i+1,dp);
        if(i<n-1 && Integer.parseInt(s.substring(i,i+2))<27){
            cnt+=memo(n,s,i+2,dp);
        }
        return dp[i] = cnt;
    }
}