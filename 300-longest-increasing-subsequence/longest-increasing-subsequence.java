class Solution {
    public int lengthOfLIS(int[] a) {
        int n = a.length;
        int[] dp  = new int[n];
        Arrays.fill(dp,1);
        for(int i =0;i<n;i++){
            for(int j =0;j<i;j++){
                if(a[i]>a[j]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
        }
        return  Arrays.stream(dp).max().getAsInt();
        
    }
}