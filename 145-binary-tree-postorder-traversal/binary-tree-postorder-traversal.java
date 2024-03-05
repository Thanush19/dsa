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
    static List<Integer> result;

    private static void traversePostOrder(TreeNode node) {
        if (node == null) return;
        if (node.left != null) {
            traversePostOrder(node.left);
        }
        if (node.right != null) {
            traversePostOrder(node.right);
        }
        result.add(node.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        traversePostOrder(root);
        return result;
    }
}