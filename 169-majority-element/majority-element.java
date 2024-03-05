class Solution {
    public int majorityElement(int[] a) {
        int ans= Integer.MAX_VALUE;
        HashMap<Integer,Integer> mp= new HashMap<>();
        int n = a.length;
        for(int i =0;i<n;i++){
            mp.put(a[i],mp.getOrDefault(a[i],0)+1);
        }
        for(int i : a){
            if(mp.get(i)>n/2) {
                ans=i;
                break;
            }
        }
        return ans;
        
    }
}