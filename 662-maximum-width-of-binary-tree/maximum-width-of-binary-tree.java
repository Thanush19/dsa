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
    class Tuple{
        int lvl,num;
        TreeNode node;
        Tuple(int lvl ,int num , TreeNode node){
            this.lvl = lvl;
            this.num = num;
            this.node = node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null )return 0;
        Queue<Tuple> q  = new LinkedList<>();
        q.offer(new Tuple(1,1,root));     
        int prevNum = 1 , prevLvl = 0,res=Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int n = q.size();
            for(int i =0;i<n;i++){
                Tuple p = q.poll();
                int lvl = p.lvl;
                int num = p.num;
                TreeNode node = p.node;
                if(prevLvl < lvl ){
                        prevLvl=lvl;
                        prevNum = num;
                }
                if(node.left!=null) q.offer(new Tuple(lvl+1,2*num,node.left));
                if(node.right!=null) q.offer(new Tuple(lvl+1,2*num+1,node.right));
                res= Math.max(res,num-prevNum+1);

            }
            

        }   
        return res;
    }
}