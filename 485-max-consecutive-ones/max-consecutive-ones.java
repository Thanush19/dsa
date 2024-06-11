class Solution {
    public int findMaxConsecutiveOnes(int[] a) {
        int n = a.length;
        int i =0,j=0,maxi=0;
        while(j<n){
            if(a[j]==1){
                j++;
            }
            else{
                maxi = Math.max(maxi, j - i); // Update maxi
                i = j + 1; // Move i to j + 1
                j++; // Move j
            }
            maxi = Math.max(maxi,j-i);
        }
        return maxi;
    }
}