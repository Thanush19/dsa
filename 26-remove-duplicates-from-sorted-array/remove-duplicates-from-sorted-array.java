
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0; // if the array is empty, return 0

        int uniqueCount = 1; // Initialize uniqueCount to 1 since the first element is always unique
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[uniqueCount] = nums[i]; // move the unique element to its correct position
                uniqueCount++; // increment uniqueCount
            }
        }
        return uniqueCount; // return the count of unique elements
    }
}