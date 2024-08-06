class Solution {
    public int minimumPushes(String s) {
        Integer[] freq = new Integer[26];
        Arrays.fill(freq, 0);
        for(char c :s.toCharArray()){
            freq[c-'a']++;
        }
        Arrays.sort(freq, Collections.reverseOrder());
        int res=0;
        for(int i =0;i<26;i++){
            int val = i/8;
            int crnt = (val+1)*freq[i];
            res+=crnt;
        }
        return res;

        
    }
}