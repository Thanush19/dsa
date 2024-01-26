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
    public boolean isBalanced(TreeNode root) {
         if(root==null) return true;
         int l = h(root.right);
         int r = h(root.left);
         if(Math.abs(l-r)<=1 && isBalanced(root.left)&& isBalanced(root.right)) return true;
         return false;



        
    }
    int h(TreeNode root){
        if(root==null) return 0;
        int r = h(root.right);
        int l = h(root.left);
        return Math.max(l,r)+1;
    }
}