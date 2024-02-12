class Solution {
    public int[] productExceptSelf(int[] a) {
        int n =a.length;
        int[] ans = new int[a.length];
        int le=1;
        for(int i =0;i<n;i++){
            ans[i]=le;
            le*=a[i];
        }
        int ri=1;
        for(int i =n-1;i>=0;i--){
            ans[i]*=ri;
            ri*=a[i];
        }
        return ans;
        
    }
}