import java.util.*;

class TimeMap {
    class Pair {
        String val;
        int time;
        
        Pair(String val, int time) {
            this.val = val;
            this.time = time;
        }
    }
    
    HashMap<String, List<Pair>> mp;

    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!mp.containsKey(key)) {
            mp.put(key, new ArrayList<>());
        }
        mp.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!mp.containsKey(key)) {
            return "";
        }
        
        return search(mp.get(key), timestamp);        
    }
    
    String search(List<Pair> pairs, int timestamp) {
        String res = "";
        int left = 0;
        int right = pairs.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Pair temp = pairs.get(mid);
            int t = temp.time;
            
            if (t == timestamp) {
                res = temp.val;
                return res;
            } else if (t < timestamp) {
                res = temp.val;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return res;
    }
}
