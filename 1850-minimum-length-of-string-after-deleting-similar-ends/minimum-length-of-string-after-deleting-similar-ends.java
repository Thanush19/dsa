class Solution {
    public int minimumLength(String s) {
        int l =0, r= s.length()-1;
        while(l<r && s.charAt(l)==s.charAt(r)){
            char ch = s.charAt(l);
            while(ch==s.charAt(l) && l<r ){
                l++;
            }
            while(ch== s.charAt(r) && r>=l) r--;
            
        }
        return r-l+1;
    }
}