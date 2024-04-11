import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        
        for (char digit : num.toCharArray()) {
            // Remove digits from the stack that are greater than the current digit
            while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        
        // Handle the case where all digits need to be removed
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        
        // Construct the result string from the remaining digits in the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        
        // Remove leading zeroes
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        
        // Handle the case where all digits are removed
        if (result.length() == 0) {
            return "0";
        }
        
        return result.toString();
    }
}
