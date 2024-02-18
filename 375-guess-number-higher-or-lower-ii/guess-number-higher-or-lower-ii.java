class Solution {
    Integer[][] dp;
    public int getMoneyAmount(int n) {
        dp = new Integer[n+1][n+1];
        return find(1, n);
    }

    int find(int a, int b){
        if(a==b) return 0;
        if(a+1==b) return a;
        if(dp[a][b]!=null)return dp[a][b];
        int res = Integer.MAX_VALUE;
        for(int i=a+1;i<b;i++){
            int t = Math.max(find(a, i-1), find(i+1, b));
            res = Math.min(i+t, res);
        }
        //System.out.println(String.format("%s,%s:%s", a, b, res));
        dp[a][b]=res;
        return res;
    }
}