class Solution {
    public int[] rearrangeArray(int[] a) {
        int n = a.length;
        int[] pos = new int[n/2];
        int[] neg = new int[n/2];
        int j =0;
        int k=0;
        for(int i = 0 ;i<n;i++){
            if(a[i]>=0){
                pos[j++]=a[i];
            }
            else neg[k++]=a[i];
        }
        int[] op = new int[n];
        int x=0,y=0,z=0;
        while(x<j && y<k){
            op[z++]=pos[x++];
            op[z++]=neg[y++];
        }
        while (x < j) {
            op[z++] = pos[x++];
        }
        while (y < k) {
            op[z++] = neg[y++];
        }
        return op;
        
    }
}