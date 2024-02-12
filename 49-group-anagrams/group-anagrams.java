class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
                Map<String,List<String>> mp = new HashMap<>();
                for(String i: strs){
                    char[] tmp1 = i.toCharArray();
                    Arrays.sort(tmp1);
                    String tmp = new String(tmp1);
                    if(!mp.containsKey(tmp)) mp.put(tmp,new ArrayList<>());
                    mp.get(tmp).add(i);
                }
                List<List<String>> list = new ArrayList<>();
                for(Map.Entry<String,List<String>> set: mp.entrySet()){
                    list.add(set.getValue());
                }
                return list;
    }
}