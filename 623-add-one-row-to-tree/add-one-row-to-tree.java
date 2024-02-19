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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode temp = new TreeNode(val);
            temp.left=root;
            return temp;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int lvl=2;
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode root1 = q.poll();
                if(lvl==depth){
                    if(root1.left!=null){
                        TreeNode temp = new TreeNode(val);
                        temp.left=root1.left;
                        root1.left=temp;
                        
                    }
                    if(root1.right!=null){
                        TreeNode temp = new TreeNode(val);
                        temp.right=root1.right;
                        root1.right=temp;
                        
                    }
                    if(root1.left==null){
                        TreeNode temp = new TreeNode(val);
                        root1.left=temp;
                    }
                    if(root1.right==null){
                        TreeNode temp = new TreeNode(val);
                        root1.right=temp;
                    }
                }
                else{
                    if(root1.left!=null){
                        q.add(root1.left);
                    }
                    if(root1.right!=null){
                        q.add(root1.right);
                    }
                }
            }
            lvl++;
            
        }

        return root;
    }
}