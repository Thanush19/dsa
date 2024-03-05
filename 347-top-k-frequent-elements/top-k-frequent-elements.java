import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> mp.get(b) - mp.get(a));
        int[] ans = new int[k];
        
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        
        pq.addAll(mp.keySet());
        
        int idx = 0;
        while (k-- > 0) {
            ans[idx++] = pq.poll();
        }
        
        return ans;
    }
}
