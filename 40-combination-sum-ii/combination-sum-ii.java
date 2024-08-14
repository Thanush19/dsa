class Solution {
   public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        combo(ans, nums, target, new ArrayList<>(), 0);
        return ans;
    }

    void combo(List<List<Integer>> ans, int[] nums, int t, ArrayList<Integer> temp, int start) {
        if (t < 0) {
            return;
        } else if (t == 0) {
            ans.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < nums.length; i++) {
                // Skip duplicates
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }

                temp.add(nums[i]);
                combo(ans, nums, t - nums[i], temp, i+1 );
                temp.remove(temp.size() - 1);
            }
        }
    }

}