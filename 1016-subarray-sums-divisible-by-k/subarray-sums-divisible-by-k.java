class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int prefixSum  = 0, count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int i=0;i<nums.length;i++){
            prefixSum += nums[i];

            int remainder = prefixSum%k;

            if(remainder < 0){
                remainder = remainder + k;
            }

            if(map.containsKey(remainder)){
                count = count + map.get(remainder);
            }

            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;

    }
}