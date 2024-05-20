class Solution {
    int fn(int[] a , int n , int idx , int ans){
        if(idx==n)return ans;
        int in = fn(a,n,idx+1,ans^a[idx]);
        int no = fn(a,n,idx+1,ans);
        return in+no;
    }
    public int subsetXORSum(int[] a) {
        return fn(a,a.length, 0,0);
        
    }
}