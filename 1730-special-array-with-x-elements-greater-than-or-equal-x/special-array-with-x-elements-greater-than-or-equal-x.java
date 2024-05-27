class Solution {
    public int specialArray(int[] nums) {
        int count = 0, incr = 0, p1 = 0, i = 1;

        while (incr < nums.length) {

            if (nums[p1] >= i) {
                count++;
            }
            p1++;
            if (p1 > nums.length - 1) {

                if (count == i)
                    return count;
                else {
                    count = 0;
                    i++;
                    p1 = 0;
                    incr++;
                }
            }
        }
        return -1;
    }
}