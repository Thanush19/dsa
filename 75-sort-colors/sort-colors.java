class Solution {
    void swap(int i , int j , int[] a){
        int temp =a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public void sortColors(int[] a) {
        int n = a.length;
        int l=0,m=0,h=n-1;
        while(m<=h){
            if(a[m]==0){
                swap(l,m,a);
                m++;
                l++;
            }
            else if(a[m]==1){
                m++;
            }
            else if(a[m]==2){
                swap(m,h,a);
              
                h--;
            }

        }
        
    }
}