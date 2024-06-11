class Solution {
    public void moveZeroes(int[] a) {
        int n = a.length;
        int j=0;
        for(int i =0;i<n;i++){
            if(a[i]!=0){
                a[j++]=a[i];
            }
        }
        while(j<n){
            a[j++]=0;
        }
        
    }
}