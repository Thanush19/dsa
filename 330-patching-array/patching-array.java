class Solution {
  public int minPatches(int[] nums, int n) {
    long maxSum = 0;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
        if (maxSum >= n) return count;
        while (maxSum + 1 < nums[i] && maxSum < n) {
            maxSum += maxSum + 1;
            count++;
        } 
        maxSum += nums[i];
    }
    while (maxSum < n) {
        maxSum += maxSum + 1;
        count++;
    }
    return count;
}
    
}