import java.util.Stack;

class Solution {
    class Pair {
        char c;
        int i;
        
        Pair(char c, int i) {
            this.c = c;
            this.i = i;
        }
    }

        public static String minRemoveToMakeValid(String s) {
        //change it to char array
        char[] ch = s.toCharArray();
        Stack<Integer>st = new Stack<>();

        for(int i = 0 ; i < ch.length ; i++) {
            //if its opening bracket push it to stack (index)
            if(ch[i] == '(')
                st.push(i);
            //if its closing bracket
            //if stack is empty then its invalid bracket market it with '.'
            //else pair exist then pop
            else if(ch[i] == ')') {
                if(st.size() == 0)
                    ch[i] = '.';
                else
                    st.pop();
            }
        }
        //If still some brackets are present in stack (Invalid)
        while (st.size() > 0) {
            //go to that index and mark it '.'
            ch[st.pop()] = '.';
        }
        // Remove all '.' from string and return
        StringBuilder sb = new StringBuilder();
        for(char c : ch) {
            if(c != '.')
                sb.append(c);
        }

        return sb.toString();
    }
}
