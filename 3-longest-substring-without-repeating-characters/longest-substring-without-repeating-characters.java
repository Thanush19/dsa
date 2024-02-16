import java.util.ArrayList;
import java.util.List;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxi = 0;
        int l = 0;
        int r = 0;
        List<Character> ans = new ArrayList<>();
        
        while (r < s.length()) {
            char currentChar = s.charAt(r);
            if (!ans.contains(currentChar)) {
                ans.add(currentChar);
                r++;
                maxi = Math.max(maxi, ans.size());
            } else {
                ans.remove(0); 
                l++; 
            }
        }
        
        return maxi;
    }
}
