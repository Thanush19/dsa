class Solution {
    public boolean isPalindrome(String s) {
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c :ch){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }

       // if(sb.length()<=1) return true;
        return fn(sb.toString());
    }
    boolean fn(String s){
       if(s.equals("")) return true;
        char[] ch = s.toCharArray();
        int l =0;
        int r = s.length()-1;
        while(l<r){
            if(ch[l]!= ch[r]) return false;
            else{
                l++;
                r--;
            }
        }
        return true;
    }
}