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
    private int dia;
    public int diameterOfBinaryTree(TreeNode root) {
         fn(root);
         return dia;
        
    }
    int fn(TreeNode root){
        if(root == null) return 0;
        int l = fn(root.left);
        int r = fn(root.right);
        dia=Math.max(dia,l+r);
        return Math.max(l,r)+1;


    }
}