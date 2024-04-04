class Solution {
    public int maxProfit(int[] a) {
        int maxi =0;
        int buy=a[0];
        for(int i = 1;i<a.length;i++){
            if(a[i]<buy){
                buy=a[i];
            }
            if(a[i]-buy>maxi){
                maxi=a[i]-buy;
            }

        }
        return maxi;
        
    }
}