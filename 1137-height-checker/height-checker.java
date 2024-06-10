class Solution {
    public int heightChecker(int[] h) {
        int[] e= Arrays.copyOf(h,h.length);
        Arrays.sort(e);
        int n = h.length;
        int i=0,cnt=0;
        while(i<h.length){
            if(h[i]!=e[i] ) cnt++;
            i++;

        }
        return cnt;

        
    }
}