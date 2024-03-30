class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        // Sliding Window Approach

        // Map to maintain frequency of elements that I am tracking less than equal to k
        HashMap<Integer, Integer> map = new HashMap<>();

        // Set to keep a track of the different k type of elements and incase of more than k one removed
        HashSet<Integer> set = new HashSet<>();

        int temp = 0;
        int si = 0;
        int j = 0;
        int cur = 0;
        int ans = 0;

        while(j < nums.length){

            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            set.add(nums[j]);

            if(set.size() > k){
                set.remove(nums[si - 1]);
                temp = 0;
            }

            while (map.size() == k) {
                map.put(nums[si], map.get(nums[si]) - 1);
                if (map.get(nums[si]) == 0){
                    map.remove(nums[si]);
                }
                temp++;
                si++;
            }

            j++;
            ans += temp;
        }

        return ans;
    }
}