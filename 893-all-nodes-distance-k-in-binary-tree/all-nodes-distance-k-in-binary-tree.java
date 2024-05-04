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
    void findPar(HashMap<TreeNode,TreeNode> par,TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i<size;i++){
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
        List<Integer> ans =  new ArrayList<>();
        if(root==null || target==null) return ans;
        HashMap<TreeNode,TreeNode> par = new HashMap<>();
        findPar(par,root);
        HashMap<TreeNode,Boolean> vis = new HashMap<>();
        int cnt=0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        vis.put(target,true);


        while(!q.isEmpty()){
            
            if(cnt==k) break;
            cnt++;
      
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode p = q.poll();
                if (p.left != null && vis.get(p.left) == null) {
                    q.offer(p.left);
                    vis.put(p.left, true); // Mark left child as visited
                }
                if (p.right != null && vis.get(p.right) == null) {
                    q.offer(p.right);
                    vis.put(p.right, true); // Mark right child as visited
                }
                TreeNode parent = par.get(p);
                if (parent != null && vis.get(parent) == null) {
                    q.offer(parent);
                    vis.put(parent, true); // Mark parent as visited
                }
            }
        }
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;

        
    }
}