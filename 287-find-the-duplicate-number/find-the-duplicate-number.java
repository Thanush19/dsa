class Solution {
    public int findDuplicate(int[] a) {
        Map<Integer,Integer> mp =new  HashMap<>();
        for(int i :a) mp.put(i,mp.getOrDefault(i,0)+1);
        for(int i : mp.keySet()){
            if(mp.get(i)>1) return i;
        }
        return -1;
        
    }
}