class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    TreeNode find(int[] nums, int l, int r) {
        if (l > r) return null;
        int m = (r - l) / 2 + l;
        TreeNode root = new TreeNode(nums[m]);
        TreeNode left = find(nums, l, m - 1);
        TreeNode right = find(nums, m + 1, r); 
        root.left = left;
        root.right = right;
        return root;
    }
}
