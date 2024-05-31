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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->x-y);
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return 0;
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i =0;i<n;i++){
                TreeNode p = q.poll();
                pq.offer(p.val);
                if(p.left!=null){
                    q.offer(p.left);
                }
                if(p.right!=null){
                    q.offer(p.right);
                }
            }
        }
        while(k-- >1){
            pq.poll();
             
        }
        return pq.poll();
    }
}