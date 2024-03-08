import java.util.*;

class Solution {
    public int maxFrequencyElements(int[] a) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i : a){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        int maxi = Collections.max(mp.values());
        int cnt=0;
        for(int i : mp.values()){
            if(i == maxi){
                cnt+=i;
            }
        }
        return cnt;
    }
}
