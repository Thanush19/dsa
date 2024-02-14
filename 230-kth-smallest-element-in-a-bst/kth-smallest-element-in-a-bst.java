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
    public int kthSmallest(TreeNode root, int k) {
        // Initialize a stack for in-order traversal
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        
        // Variable to track the count of visited nodes
        int count = 0;
        
        // Perform in-order traversal
        while (current != null || !stack.isEmpty()) {
            // Traverse left subtree and push nodes onto stack
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            // Pop node from stack
            current = stack.pop();
            count++;
            
            // If count equals k, return the value of current node
            if (count == k)
                return current.val;
            
            // Move to right subtree
            current = current.right;
        }
        
        return -1; // BST is invalid or k is out of range
    }
}
