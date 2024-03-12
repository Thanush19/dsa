class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] ans = new int[temp.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < temp.length; i++) {
            while (!st.isEmpty() && temp[st.peek()] < temp[i]) {
                int prev = st.pop();
                ans[prev] = i - prev;
            }
            st.push(i);
        }
        return ans;
    }
}
