/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
   void fnTofindPar(   HashMap<TreeNode,TreeNode> par,TreeNode root){
        if(root==null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0 ;i<n;i++){
                TreeNode p = q.poll();
                if(p.left!=null) {
                    par.put(p.left,p);
                    q.offer(p.left);
                }
                if(p.right!=null) {
                    par.put(p.right,p);
                    q.offer(p.right);
                }
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> par = new HashMap<>();
        fnTofindPar(par,root);
        List<Integer> ans = new ArrayList<>();
        HashMap<TreeNode,Boolean> vis = new HashMap<>();
        vis.put(target,true);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);


        int cnt =0;
        while(!q.isEmpty()){
            if(cnt==k) break;
            cnt++;
            int n = q.size();
            for(int i = 0;i<n ;i++){
                TreeNode p = q.poll();
                if(p.left!=null && vis.get(p.left)==null){
                    vis.put(p.left,true);
                    q.offer(p.left);

                }
                if(p.right!=null && vis.get(p.right)==null){
                    vis.put(p.right,true);
                    q.offer(p.right);


                }
                if(par.get(p)!=null && vis.get(par.get(p))==null){
                    vis.put(par.get(p),true);
                    q.offer(par.get(p));
                }

            }
           
        }
         while(!q.isEmpty()){
                ans.add(q.poll().val);
        }
            return ans;

        
    }
}