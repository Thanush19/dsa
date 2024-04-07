class Solution {
    public boolean checkValidString(String s) {
        //stack
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stars = new Stack<>();
        int count = 0; //count of stars
        
        //push ( to stack, keep count of stars
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '*') stars.push(i);
            
            if(c == '(') stack.push(i);

            if(c == ')') {
                if(!stack.isEmpty()) {
                    stack.pop();
                }else if(!stars.isEmpty()) {
                    stars.pop();
                }else{
                    return false;
                }
            }
        }

        //stack is not empty, with surplus of (, compare that to count
        while(!stack.isEmpty() && !stars.isEmpty()) {
            if(stack.peek() > stars.peek()) return false;
            stack.pop();
            stars.pop();
        }

        return stack.isEmpty();
    }
}

//((**(**((