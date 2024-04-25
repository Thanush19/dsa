class Solution {
    public int longestIdealString(String s, int k) {
        Integer[][] memo = new Integer[s.length()+1][27];
        return find(s, 1, 0, k, memo);
    }
    
    private int find(String s, int idx, int prev, int k, Integer memo[][]) {
        if(idx-1==s.length()) return 0;
        
        if(memo[idx][prev]!=null) return memo[idx][prev];
        
        int res = 0;
        if(prev==0 || Math.abs(s.charAt(idx-1) -'a' - prev+1) <=k) {
            res = 1 + find(s, idx+1, s.charAt(idx-1)-'a'+1, k, memo);
        } 
        res = Math.max(res, find(s, idx+1, prev, k, memo));
        memo[idx][prev] = res;
        
        return memo[idx][prev];
    }
}