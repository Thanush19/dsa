class Solution {
    public int findSubstringInWraproundString(String s){
        int dp[] = new int[s.length()];
        dp[s.length() - 1] = 1;
        int maxArray[] = new int[26];
        maxArray[s.charAt(s.length()-1) - 'a'] = 1;
        for(int i = s.length() - 2 ; i >= 0 ; i--){
            if(s.charAt(i) == s.charAt(i+1) - 1 || s.charAt(i) == 'z' && s.charAt(i+1) == 'a'){
                dp[i] = 1 + dp[i+1];
            }else{
                dp[i] = 1;
            }
            int key = s.charAt(i) - 'a';
            maxArray[key] = Math.max(maxArray[key],dp[i]);
        }
        int res = 0;
        for(int i=0;i<26;i++){
            res = res + maxArray[i];
        }
        return res;
    }
}