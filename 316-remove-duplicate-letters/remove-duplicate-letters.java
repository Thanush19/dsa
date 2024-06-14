class Solution {
    public String removeDuplicateLetters(String str) {
        int n = str.length();
        
        Stack<Character> s = new Stack<>();
        int[] freq = new int[26];
        
        HashSet<Character> set = new HashSet<>();
        
        for(char c : str.toCharArray()) freq[c-'a']++;
        
        
        for(char c : str.toCharArray()){
            
            freq[c-'a']--;
            if(set.contains(c)) continue;
            
            while(!s.isEmpty() && s.peek() > c && freq[s.peek()-'a'] !=0 ){
                
                set.remove(s.pop());
            }
            
            s.add(c);
            set.add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
            
        return sb.reverse().toString();
    }
}