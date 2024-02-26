class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] palindrome = new boolean[n][n];
        int ans = 0;

        for(int len=1;len<=n;len++) {
            for(int i=0;i<n-len+1;i++) {
                if(s.charAt(i) == s.charAt(i+len-1) 
                    && (len <= 2 || palindrome[i+1][i+len-2])) {
                    palindrome[i][i+len-1] = true;
                    ans++;
                }
            }
        }

        return ans;
    }
}