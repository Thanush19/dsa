class Solution {
    public String frequencySort(String s) {
        char[] ch = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        HashMap<Character, Integer> mp= new HashMap<>();
        for(char c: ch){
            mp.put(c,mp.getOrDefault(c,0)+1);
        } 
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->mp.get(b)-mp.get(a));
        pq.addAll(mp.keySet());

        while(!pq.isEmpty()){
            char crnt = pq.poll();
            int fre = mp.get(crnt);
            for(int i =0;i<fre;i++){
                ans.append(crnt);
            }
        }
        return ans.toString();
        
    }
}