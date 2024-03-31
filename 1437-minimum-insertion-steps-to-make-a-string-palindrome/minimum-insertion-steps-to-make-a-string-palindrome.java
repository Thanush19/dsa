class Solution {
    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        int n = rev.length();
        int[][] dp = new int[n+1][n+1];
        for(int i =1 ; i<=n;i++){
            for(int j =1 ; j<= n ; j++){
                if(s.charAt(i-1)== rev.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                else {
                    int yes = dp[i][j-1];
                    int no = dp[i-1][j];
                    dp[i][j]= Math.max(yes,no);
                }
             }
        }
        return n - dp[n][n];


        
    }
}