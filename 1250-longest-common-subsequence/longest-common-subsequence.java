class Solution {
    public int fn(int[][] dp, int i1, int i2, String s1 , String s2){
        if(i1<0 || i2<0) return 0;
        if(dp[i1][i2]!=-1) return dp[i1][i2];
         int ans=Integer.MIN_VALUE;
        if(s1.charAt(i1)==s2.charAt(i2)) return dp[i1][i2]=1+fn(dp,i1-1,i2-1,s1,s2);
       
        else{
            int yes = fn(dp,i1-1, i2,s1,s2);
            int no = fn(dp,i1,i2-1, s1,s2);
            ans = Math.max(yes,no);
        }
        return dp[i1][i2]=ans;

    }

    public int longestCommonSubsequence(String s1, String s2) {
        int t1 = s1.length();
        int t2 = s2.length();
        int[][] dp = new int[t1][t2];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
        return fn(dp,t1-1,t2-1, s1,s2);


        
    }
}