class Solution {
    private boolean compare(String s1, String s2){
        if(s1.length() != s2.length() + 1) return false;
        int first = 0;
        int second = 0;
        while(first < s1.length()){
            if(second < s2.length() && s1.charAt(first) == s2.charAt(second)){
                first++;
                second++;
            }else{
                first++;
            }
        }
        return (first == s1.length() && second == s2.length());
    }
    private Comparator<String> comp = ((s1,s2) -> s1.length() - s2.length());
    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int maxi = 1;
        Arrays.sort(words,comp);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(compare(words[i],words[j]) && dp[i] < 1 + dp[j]){
                    dp[i] = 1 + dp[j];
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }
        return maxi;
    }
}