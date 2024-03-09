import java.util.ArrayList;
import java.util.List;

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        int x = 0, y = 0;
        
        while (x < nums1.length && y < nums2.length) {
            if (nums1[x] == nums2[y]) {
                ans.add(nums1[x]);
                x++;
                y++;
            } else if (nums1[x] < nums2[y]) {
                x++;
            } else {
                y++;
            }
        }
        
        if (ans.isEmpty()) {
            return -1;
        } else {
            int min = Integer.MAX_VALUE;
            for (int num : ans) {
                if (num < min) {
                    min = num;
                }
            }
            return min;
        }
    }
}
