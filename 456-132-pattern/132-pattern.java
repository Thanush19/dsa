class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack();
        int j = Integer.MIN_VALUE;
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i] < j) return true;
            while(!stack.isEmpty() && stack.peek() < nums[i]){
                j = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}