class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        int[] cnt = new int[26];
        int most = 0;
        int maxi = 0;

        while (r < s.length()) {
            if (Character.isUpperCase(s.charAt(r))) {
                cnt[s.charAt(r) - 'A']++;
                most = Math.max(most, cnt[s.charAt(r) - 'A']);
            }

            if (r - l + 1 - most > k) {
                if (Character.isUpperCase(s.charAt(l))) {
                    cnt[s.charAt(l) - 'A']--;
                }
                l++;
            }
            maxi = Math.max(r - l + 1, maxi);
            r++;
        }
        return maxi;
    }
}
