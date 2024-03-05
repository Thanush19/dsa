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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return find(root,ans);
        
    }
     List<Integer> find( TreeNode root,List<Integer> ans){
         if(root!=null){
             find(root.left,ans);
             ans.add(root.val);
             find(root.right,ans);


         }
         return ans;
     }
}