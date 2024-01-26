/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateDiameter(root);
        return diameter;
    }

    private int calculateDiameter(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Calculate height of left and right subtrees
        int leftHeight = calculateDiameter(node.left);
        int rightHeight = calculateDiameter(node.right);

        // Update diameter using the sum of left and right heights
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return the height of the current subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
