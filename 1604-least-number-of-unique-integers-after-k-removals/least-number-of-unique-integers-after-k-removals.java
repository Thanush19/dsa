import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int findLeastNumOfUniqueInts(int[] a, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i : a){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> mp.get(x) - mp.get(y));
        for(int key : mp.keySet()){
            pq.add(key);
        }
        
        while(k > 0 && !pq.isEmpty()){
            k -= mp.get(pq.poll());
        }
        
        return k < 0 ? pq.size() + 1 : pq.size();
    }
}
