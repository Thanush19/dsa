class Solution {
    public int longestConsecutive(int[] a) {
        HashSet<Integer> s = new HashSet<>();
        for (int num : a) {
            s.add(num);
        }
        int maxi = Integer.MIN_VALUE;
        for(int  i : s){
            int cnt=0;
            if(!s.contains(i-1)){
                cnt++;
                int p=i;
                while(s.contains(p+1)){
                    cnt++;
                    p++;
                }
                maxi = Math.max(cnt,maxi);

            }
        }
        return maxi== Integer.MIN_VALUE?0:maxi;
        
    }
}