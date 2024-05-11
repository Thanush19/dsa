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
    int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
        int h=fn(root);
        return ans;
        
    }
    int fn(TreeNode r){
        if(r==null) return 0;
        int lh = fn(r.left);
        int rh = fn(r.right);
        ans=Math.max(lh+rh,ans);
        return Math.max(lh,rh)+1;
    }
}