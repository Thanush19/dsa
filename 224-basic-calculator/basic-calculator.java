class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int sign=1;
        int res=0;
        int num=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num*10 + (ch-'0');
            }
            else if(ch=='+'){
                res += num*sign;
                sign=1;
                num=0;
            }
            else if(ch=='-'){
                res += num*sign;
                sign=-1;
                num=0;
            }
            else if(ch=='('){
                st.push(res);
                st.push(sign);
                sign=1;
                num=0;
                res=0;
            }
            else if(ch==')'){
                res += num*sign;
                num=0;

                int stack_sign=st.pop();
                int last_res=st.pop();

                res *= stack_sign;
                res += last_res;
            }
        }
        res += num*sign;
        return res;
    }
}