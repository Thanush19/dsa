class Solution {
    int fn(int[] a, int idx , int prev, int[][] dp) {
        if(idx==a.length) return 0;
        if(dp[idx][prev+1]!=-1) return dp[idx][prev+1];
        //without taking the element , we are just moving to nxt elemt , so prev will be same; , i dont add extra value in len
        int no = 0+fn(a,idx+1,prev,dp); 
        int yes = 0;
        if(prev==-1 ||(prev >= 0 && a[idx] > a[prev])){
            yes =1+ fn(a,idx+1,idx,dp);
        }
        dp[idx][prev+1]=Math.max(no,yes);
        //coordinate change to +1 for prev , because it starts from -1, i cant store store -1 in dp, that's why'
        return dp[idx][prev+1];

    }
    public int lengthOfLIS(int[] a) {
        int n = a.length;
        int[][] dp = new int[n][n+1];
        for(int[] i : dp) Arrays.fill(i,-1);
        return fn(a,0,-1,dp);
        
    }
}