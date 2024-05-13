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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean lTr = true;
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            //
            int n = q.size();
            List<Integer> temp =new ArrayList<>();

            for(int i = 0  ; i<n;i++){
                 TreeNode p = q.poll();
                 
                 if(lTr){
                    temp.add(p.val);
                }
                else{
                    temp.add(0,p.val);
                }
                if(p.left!=null) q.offer(p.left);
                if(p.right!=null) q.offer(p.right);
            }
            lTr=!lTr;
            ans.add(temp);

        }
        return ans;

        
    }
}