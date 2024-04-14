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
    public int sumOfLeftLeaves(TreeNode root) {
         if (root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) // Check if left child is a leaf
                    sum += node.left.val;
                else
                    queue.offer(node.left);
            }
            
            if (node.right != null) {
                if (node.right.left != null || node.right.right != null) // Check if right child has further nodes
                    queue.offer(node.right);
            }
        }
        
        return sum;
        
    }
}