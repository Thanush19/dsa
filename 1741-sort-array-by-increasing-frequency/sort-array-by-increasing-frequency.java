import java.util.*;

class Solution {
    class Pair {
        int e, i;
        Pair(int e, int i) {
            this.e = e;
            this.i = i;
        }
    }

    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        List<Pair> temp = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
            temp.add(new Pair(e.getKey(), e.getValue()));
        }

        Collections.sort(temp, (x, y) -> {
            if (x.i != y.i) {
                return x.i - y.i;  
            } else {
                return y.e - x.e;
            }
        });

        int index = 0;
        for (Pair pair : temp) {
            for (int j = 0; j < pair.i; j++) {
                ans[index++] = pair.e;
            }
        }

        return ans;
    }

}
