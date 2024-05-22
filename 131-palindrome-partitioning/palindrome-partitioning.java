
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        pal(ans, s, new ArrayList<>(), 0);
        return ans;
    }

    void pal(List<List<String>> ans, String s, List<String> temp, int start) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            if (isPal(s, start, i - 1)) {
                temp.add(s.substring(start, i));
                pal(ans, s, temp, i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    boolean isPal(String s, int st, int e) {
        while (st < e) {
            if (s.charAt(st++) != s.charAt(e--)) {
                return false;
            }
        }
        return true;
    }
}
