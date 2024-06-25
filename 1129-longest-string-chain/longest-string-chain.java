class Solution {
    boolean compare(String s1,String s2){
        if(s1.length() != s2.length() + 1) return false;
        int i =0,j=0;
        while(i<s1.length() && j < s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }
            else i++;
        }
        return j==s2.length() ;

    }
    public int longestStrChain(String[] w) {
        int n = w.length;
        Arrays.sort(w,(s1,s2)->s1.length()-s2.length());
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i =1;i<n;i++){
            for(int j=0;j<i;j++){
                if(compare(w[i],w[j])&& 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();

        
    }
}