class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char i : s.toCharArray()){
            if(i=='(' || i == '{' || i=='['){
                st.push(i);
            }
              else if(st.isEmpty()) {
                return false; // If the stack is empty and we encounter a closing bracket, return false
            }
            else if(!st.isEmpty() && st.peek()=='(' && i==')') st.pop();
            else if(!st.isEmpty() && st.peek()=='{' && i=='}') st.pop();
            else if(!st.isEmpty() && st.peek()=='[' && i==']') st.pop();
              else {
                return false; // If the top of the stack does not match the current closing bracket, return false
            }
        }
        return st.isEmpty();
        
    }
}