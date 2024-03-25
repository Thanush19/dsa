class Solution {
    public List<Integer> findDuplicates(int[] a) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i : a){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        for(int i : mp.keySet()){
            if(mp.get(i)==2) ans.add(i);
        }
        return ans;
        
    }
}