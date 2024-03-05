import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = st.pop();
                int a = st.pop();
                int result = evaluate(a, b, token);
                st.push(result);
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int evaluate(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return 0; // Handle invalid operator or any other cases
        }
    }
}
