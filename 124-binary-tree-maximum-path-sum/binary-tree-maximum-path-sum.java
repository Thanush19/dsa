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
    public int maxPathSum(TreeNode root) {
        int[] maxp=new int[1]; //to pass the maxp integer by reference
        maxp[0]=Integer.MIN_VALUE; //because we have to compare to find max
        solver(root,maxp);
        return maxp[0];
    }

    public int solver(TreeNode root, int[] maxp){
        if(root==null) return 0;
        int lh=solver(root.left,maxp); //max path sum from left 
        int rh=solver(root.right,maxp); //max path sum from right
        maxp[0]=Math.max(maxp[0],lh+rh+root.val); 
        int ret= Math.max(root.val,Math.max(lh,rh)+root.val); //max of root and 
        maxp[0]=Math.max(maxp[0],ret);// max stores the max of (root value, root+maxLeft/right ,path sum including the node from right to left,previous max)
        //max can be a discontinuos set sum but returned value is a continous part of branch of tree
        return ret; //max path sum from this node 
    }
}