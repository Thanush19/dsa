class Solution {
    public int maxSubarrayLength(int[] a, int k) {

        int n = a.length;
        int l =0;
        int maxi = Integer.MIN_VALUE;
        HashMap<Integer,Integer>  mp = new HashMap<>();
        for(int r =0; r<n;r++){
            mp.put(a[r],mp.getOrDefault(a[r],0)+1);
            while(mp.get(a[r])>k){
                mp.put(a[l],mp.get(a[l])-1);
                l++;
                    
            }
                
            
            maxi= Math.max(maxi,r-l+1);
            
        }


        

        return maxi;
        
    }
}
