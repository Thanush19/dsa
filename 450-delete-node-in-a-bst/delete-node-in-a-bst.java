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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val == key) return helper(root);

        TreeNode curr = root;

        while(curr != null) {
            if(curr.val > key) {
                if(curr.left != null && curr.left.val == key) {
                    curr.left = helper(curr.left);
                }
                else curr = curr.left;
            }

            else {
                if(curr.right != null && curr.right.val == key) {
                    curr.right = helper(curr.right);
                }
                else curr = curr.right;
            }
        }

        return root;
    }

    public TreeNode helper(TreeNode root) {
        if(root.left == null) return root.right;
        if(root.right == null) return root.left;

        TreeNode rightChild = root.right;
        TreeNode lastRight = findLast(root.left);
        lastRight.right = root.right;
        return root.left;
    }

    public TreeNode findLast(TreeNode root) {
        while(root.right != null) root = root.right;
        return root;
    }
}