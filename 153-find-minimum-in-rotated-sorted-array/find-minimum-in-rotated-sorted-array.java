class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If the middle element is greater than the rightmost element, we know that
            // the minimum element must be on the right side of the mid.
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // If the middle element is less than or equal to the rightmost element, we
            // know that the minimum element must be on the left side of the mid, including
            // the mid element.
            else {
                right = mid;
            }
        }

        // The 'left' index will point to the minimum element when the loop exits.
        return nums[left];
    }
}