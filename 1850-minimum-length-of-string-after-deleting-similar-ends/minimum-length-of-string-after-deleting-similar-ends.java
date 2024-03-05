class Solution {
    public int minimumLength(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            char ch = s.charAt(l);
            while (l <= r && ch == s.charAt(l)) {
                l++;
            }
            while (l <= r && ch == s.charAt(r)) {
                r--;
            }
        }
        return r - l + 1;
    }
}
