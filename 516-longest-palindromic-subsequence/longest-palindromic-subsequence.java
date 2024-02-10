class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] cache = new int[s.length()+1][];
        for (int i = 0; i < cache.length; i++) {
            int[] tmp = new int[s.length() + 1];
            Arrays.fill(tmp, -1);
            cache[i] = tmp;
        }

        int ans = 1;

        ans = 1;

        for (int i = 0; i < s.length() - 1; i++) {
            ans = Math.max(ans, dp(i, i, s, cache));
            ans = Math.max(ans, dp(i, i+1, s, cache));
        }

        return ans;
    }


    public static int dp(int lc, int rc, String s, int[][] cache) {
        if (lc < 0 || rc == s.length()) return 0;
        if (cache[lc][rc] != -1) return cache[lc][rc];
        if (s.charAt(lc) != s.charAt(rc)) {
            int t1 = dp(lc - 1, rc, s, cache);
            int t2 = dp(lc, rc + 1, s, cache);
            cache[lc][rc] = Math.max(t1, t2);
            
        } else {
            int res = lc == rc ? 1 : 2;
            cache[lc][rc] = dp(lc - 1, rc + 1,  s, cache) + res;
        }
        return cache[lc][rc];
    }
}