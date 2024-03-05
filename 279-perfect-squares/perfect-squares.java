class Solution {
    public int numSquares(int n) {
        
        this.memo = new int[n+1];

        Arrays.fill(memo,-1);

        return dp(n);

    }

    int[] memo;

    int dp(int n){

        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;

        if(memo[n]!=-1) return memo[n];


        int min = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){

            int power = i*i;
            if(n-power>=0){

                min = Math.min(min, dp(n-power)+1);

            }

        }

        memo[n] = min;

        return min;


    }

}