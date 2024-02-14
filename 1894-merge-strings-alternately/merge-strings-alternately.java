class Solution {
    public String mergeAlternately(String w1, String w2) {
        String ans = "";
        char[] c1 = w1.toCharArray();
        char[] c2 = w2.toCharArray();
        int n1 = w1.length();
        int n2 = w2.length();
        int i =0,j=0;
        while(i<n1 && j <n2){
            ans+=c1[i++];
            ans+=c2[j++];
        }
        while(i<n1){
          ans+=c1[i++];
        }
        while(j<n2){
            ans+=c2[j++];
        }
        return ans;
        
    }
}