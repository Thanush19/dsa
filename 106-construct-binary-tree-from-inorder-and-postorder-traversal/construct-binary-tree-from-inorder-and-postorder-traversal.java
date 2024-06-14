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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return helperTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
    }

    public TreeNode helperTree(int[] inorder,int instart,int inend,int[] postorder,int poststart,int postend,HashMap<Integer,Integer> map){
        if(instart > inend || poststart > postend){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postend]);
        int temp = map.get(root.val);
        int numsleft = temp - instart;

        root.left = helperTree(inorder,instart,temp-1,postorder,poststart,poststart+numsleft-1,map);
        root.right = helperTree(inorder,temp+1,inend,postorder,poststart+numsleft,postend-1,map);

        return root;
    }
}