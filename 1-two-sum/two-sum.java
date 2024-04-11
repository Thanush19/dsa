class Solution {
    public int[] twoSum(int[] a, int t) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int  i =0;i<a.length;i++){
            int bal = t-a[i];
            if(mp.containsKey(bal)){
                return new int[]{mp.get(bal),i};
            }
            mp.put(a[i],i);
        }
        return new int[]{};
        
    }
}