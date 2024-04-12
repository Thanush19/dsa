class Solution {
    public List<Integer> largestDivisibleSubset(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        for(int i =0;i<n;i++) hash[i]=i;
        Arrays.fill(dp,1);
        Arrays.sort(a);
        for(int i =0;i<n;i++){
            for(int j = 0 ;j<i;j++){
                if(a[i]%a[j]==0 && dp[i]<1+dp[j]){
                    dp[i]=1+dp[j];
                    hash[i]=j;
                }
            }
        }
        int ans  = -1;
        int lastIdx=-1;
        for(int i =0;i<n;i++){
            if(ans<dp[i]){
                ans=dp[i];
                lastIdx=i;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(a[lastIdx]);
        while(hash[lastIdx]!=lastIdx){
            lastIdx=hash[lastIdx];
            res.add(a[lastIdx]);
        }
        Collections.reverse(res);
        return res;

        
    }
}