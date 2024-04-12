class Solution {
  
    public int lengthOfLIS(int[] arr) {
        // int n = arr.length;
        // int dp[][]=new int[n+1][n+1];
    
        // for(int ind = n-1; ind>=0; ind --){
        //     for (int prev_index = ind-1; prev_index >=-1; prev_index --){
                
        //         int notTake = 0 + dp[ind+1][prev_index +1];
        
        //         int take = 0;
        
        //         if(prev_index == -1 || arr[ind] > arr[prev_index]){
                    
        //             take = 1 + dp[ind+1][ind+1];
        //         }
        
        //         dp[ind][prev_index+1] = Math.max(notTake,take);
                
        //     }
        // }
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i = 0;i<n;i++){
            for(int j = 0 ;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i]= Math.max(dp[i],1+dp[j]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();

        
        // return dp[0][0];
        
    }
}