class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int num :nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
            if(mp.get(num)>1) return true;
        }
        return false;

        
    }
}