class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i : nums){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        int[] ans =new int[2];
        int j=0;
        for(Map.Entry<Integer,Integer>  e : mp.entrySet()){
            if(e.getValue()==1) ans[j++]=e.getKey();
        }
        return ans;
        
    }
}