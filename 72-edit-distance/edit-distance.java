class Solution {
    int fn(String s , String t , int i ,  int j , int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        int ans = Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)== t.charAt(j) ) return dp[i][j]=fn(s,t,i-1,j-1,dp);

        else{
            int ins = 1+fn(s,t,i,j-1,dp);
            int rem = 1+fn(s,t,i-1,j,dp);
            int rep = 1+fn(s,t,i-1,j-1,dp);
            ans = Math.min(Math.min(ins,rem),rep);

            
        }
        return dp[i][j]= ans;
        
    }
    public int minDistance(String s, String t) {
        int  n =s.length();
        int  m =t.length();
        int[][] dp = new int[n][m];
        for(int[] i : dp) Arrays.fill(i,-1);
        return fn(s,t,n-1,m-1,dp);
        
    }
} 