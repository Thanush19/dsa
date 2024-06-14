class Solution {
    int n;
    public boolean circularArrayLoop(int[] nums) {
        n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            boolean isForward=(nums[i]>=0);
            if (dfs(i, nums, set,isForward)) {
                return true;
            }
        }
        return false;
    }

    public boolean dfs(int si, int nums[], Set<Integer> set,boolean isForward) {
        if(si<0 || si>=nums.length) return false;
        if(nums[si]<0 && isForward==true) return false;
        if(nums[si]>=0 && isForward==false) return false; 
        int index=(nums[si]+si)%n;
        if(index<0){
            index=n+index;
        }
        if(index==si) return false;
        if(set.contains(index)) return true;
        set.add(index);
        if(dfs(index,nums,set,isForward)){
            return true;
        }
        return false;
    }
}