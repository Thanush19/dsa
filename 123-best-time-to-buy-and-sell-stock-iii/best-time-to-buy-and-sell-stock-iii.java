class Solution {
    int fn(int[] a , int idx,    int[][][] dp , int cap,int flag){
        if(idx==a.length|| cap ==0 ) return 0;
        if(dp[idx][flag][cap]!=-1) return dp[idx][flag][cap];
        int pro=0;
        //buy;
        if(flag==0){
            //firts i=option , ic an buy stock , and in nxt step i can go to sell postion or without buing , i can move to next stock
            pro = Math.max(-a[idx]+fn(a,idx+1,dp,cap,1),fn(a,idx+1,dp,cap,0));

        } 
        //sell
        else{
            //i can eighter sell ithe stock so that the cap-- , or even i can go for next stock price where it is cheap so that i can get maxi profit
            pro= Math.max((a[idx]+fn(a,idx+1,dp,cap-1,0)),fn(a,idx+1,dp,cap,1));

        }
        return dp[idx][flag][cap]=pro;
    }
    public int maxProfit(int[] a) {
        int n = a.length;
        //                    [no.of indexes ][buy/sell flag][no .of cap --> atmost 2 -->0|1|2];
        //0---> buy , 1----> sell;
        int[][][] dp = new int[n+1][2][3];
        for(int i =0;i<=n ;i++){
            for(int j = 0 ; j<2;j++){
                for(int z =0;z<3;z++){
                    dp[i][j][z]=-1;

                }
                
            }
        }
        return fn(a,0, dp,2,0);

        
    }
}