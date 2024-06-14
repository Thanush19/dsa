// TC:O(n^4)
// SC:O(1)
// class Solution {
//     public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
//         int count = 0;
//         for (int i = 0; i < nums1.length; i++) {
//             for (int j = 0; j < nums2.length; j++) {
//                 for (int k = 0; k < nums3.length; k++) {
//                     for (int l = 0; l < nums4.length; l++) {
//                         if ((nums1[i] + nums2[j] + nums3[k] + nums4[l]) == 0)
//                             count++;
//                     }
//                 }
//             }
//         }
//         return count;
//     }
// }



// TC:O(n^2)
// SC:O(n^2)
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                map.put(n1 + n2, map.getOrDefault(n1 + n2, 0) + 1);
            }
        }

        int count = 0;
        for (int n3 : nums3) {
            for (int n4 : nums4) {
                count += map.getOrDefault(-(n3 + n4), 0);
            }
        }
        return count;
    }
}