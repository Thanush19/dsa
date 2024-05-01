class Solution {
    String fn(String s , char c){
        int[] mp = new int[26];
        String s1 = "";
        String s2 = "";
        for (int i =0;i<s.length();i++){
            mp[s.charAt(i)-'a']++;
            if(c==s.charAt(i) && mp[c-'a']==1){
                s1=s.substring(0,i+1);
                s2=s.substring(i+1,s.length());
            }    
        }
        StringBuilder ans = new StringBuilder(s1);
        return ans.reverse().toString()+s2;
    }
    public String reversePrefix(String word, char ch) {
       
        if( word.contains(String.valueOf(ch))){
            return fn(word,ch);

        }
        return word;
        
    }
}