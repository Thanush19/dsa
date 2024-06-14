class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0;
        int r=0;
        int currSum=0;
        int miniL=Integer.MAX_VALUE;
        while(r<nums.length){
            currSum+=nums[r];
            while(l<=r && currSum>=target){
                miniL=Math.min(miniL,r-l+1);
                currSum-=nums[l++];
            }
            ++r;
        }
        return miniL==Integer.MAX_VALUE?0:miniL;


        
    }
}