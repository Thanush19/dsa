class Solution {
    public void rotate(int[] a, int k) {
 int n = a.length; 
 if(n<=1) return ;
         k = k % n;

 
        rev(a,0,n-1);
         rev(a,0,k-1);
        rev(a,k,n-1);
        
    }
    void rev(int[] a , int s , int e){
        while(s<e){
            int t  = a[s];
            a[s]=a[e];
            a[e]=t;
            s++;
            e--;
        }
    }
}