class Solution {
    public int triangleNumber(int[] nums) {
        // Sort the input array
        Arrays.sort(nums);
        
        int n = nums.length;
        int count = 0;
        
        // Iterate through the array from right to left
        for (int i = n - 1; i >= 1; i--) {
            int left = 0;
            int right = i - 1;
            
            // Use two pointers approach to find valid triangles
            while (left < right) {
                // If the sum of two smaller sides is greater than the largest side, it forms a valid triangle
                if (nums[left] + nums[right] > nums[i]) {
                    // Increment count by the number of valid triangles found between left and right pointers
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        
        return count;
    }
}