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
    int fn(TreeNode root){
        if(root==null) return 0;
        int lh = fn(root.left);
        int rh = fn(root.right);
        if(Math.abs(lh-rh)>1) return -1;
        if(lh==-1 || rh==-1) return -1;
        return 1+Math.max(lh,rh);
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int ans = fn(root);
        return ans==-1?false : true;
        
    }
}