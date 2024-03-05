import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        // Create a frequency map for characters in t
        Map<Character, Integer> targetFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }

        int requiredChars = targetFreq.size();
        int left = 0, right = 0;
        int formed = 0;

        // Create a frequency map for characters in the current window
        Map<Character, Integer> windowFreq = new HashMap<>();

        // Variables to keep track of the minimum window substring
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0, minRight = 0;

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            windowFreq.put(currentChar, windowFreq.getOrDefault(currentChar, 0) + 1);

            if (targetFreq.containsKey(currentChar) && windowFreq.get(currentChar).equals(targetFreq.get(currentChar))) {
                formed++;
            }

            // Try to minimize the window by moving the left pointer
            while (formed == requiredChars && left <= right) {
                int currentLen = right - left + 1;

                if (currentLen < minLen) {
                    minLen = currentLen;
                    minLeft = left;
                    minRight = right + 1;
                }

                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

                if (targetFreq.containsKey(leftChar) && windowFreq.get(leftChar) < targetFreq.get(leftChar)) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight);
    }
}
