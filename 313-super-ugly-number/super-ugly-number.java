class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m= primes.length;
        PriorityQueue<int[]> q= new PriorityQueue<>((a,b) -> a[2]-b[2]);
        for(int i=0; i<m; i++){
            q.add(new int[]{primes[i],1,primes[i]});
        }
        
        int[] dp= new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2; i<=n;){
            int[] cur= q.poll();
            if(dp[i-1]!=cur[2]){
                dp[i]= cur[2];
                i++;
            }
            
            q.add(new int[]{cur[0],cur[1]+1, cur[0]*dp[cur[1]+1]});
        }
        
        return dp[n];
    }
}