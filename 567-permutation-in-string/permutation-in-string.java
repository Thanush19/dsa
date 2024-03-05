class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> have = new HashMap<>();
        
        for (char i : s1.toCharArray()) {
            need.put(i, need.getOrDefault(i, 0) + 1);
        }
        
        int e = 0, s = 0;
        while (e < s2.length()) {
            char crnt = s2.charAt(e);
            if (!need.containsKey(crnt)) {
                e++;
                s = e;
                have.clear();
            } else {
                have.put(crnt, have.getOrDefault(crnt, 0) + 1);
                e++;
                
                while (have.getOrDefault(crnt, 0) > need.getOrDefault(crnt, 0)) {
                    char st = s2.charAt(s);
                    have.put(st, have.get(st) - 1);
                    s++;
                }
                
                int win = e - s;
                if (win == s1.length()) return true;
            }
        }
        return false;
    }
}
