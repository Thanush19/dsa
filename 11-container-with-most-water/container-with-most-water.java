class Solution {
    public int maxArea(int[] h) {
        int n = h.length;
        int  l = 0;
        int r = n-1;
        int maxi=0;
        while(l<=r){
            int crnt=0;
            int len = r-l;
            int b = 0;
            if(h[l]<h[r]) {
                b=h[l];
                l++;
            }
            else {
                b=h[r];
                r--;
            }
            crnt= len*b;
            maxi=Math.max(crnt,maxi);
            
        }
        return maxi;

        
    }
}