/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
         StringBuilder result = new StringBuilder();
        if(root==null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node==null){
                result.append("null ");
            }
            else{
                result.append(node.val+" ");
                q.add(node.left);
                q.add(node.right);
            }
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        String[] s = data.split(" ");
        TreeNode ans = new TreeNode(Integer.parseInt(s[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(ans);

        for(int i =1;i<s.length;i++){
            TreeNode p=q.poll();
            if(!s[i].equals("null")){
                p.left=new TreeNode(Integer.parseInt(s[i]));
                q.offer(p.left);
            }
            i++;
            if(!s[i].equals("null")){
                p.right=new TreeNode(Integer.parseInt(s[i]));
                q.offer(p.right);
            }

        }
        return ans;

        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));