class Solution {
    public int maxDepth(String s) {
        if(s.equals("")) return 0;
        int cnt=0;
        int maxi=Integer.MIN_VALUE;
        for(int i = 0 ;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(')cnt++;
            if(c==')')cnt--;
            maxi = Math.max(cnt,maxi);
        }
        return maxi;

        
    }
}