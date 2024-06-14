public class Codec { // 20ms solution
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "#";
        return root.val+" "+serialize(root.left)+" "+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    String[] arr;int index;
    public TreeNode deserialize(String data) {
        arr=data.split(" ");
        index=0;
        return go();
    }
    
    private TreeNode go() {
        int index=this.index++;
        if(arr[index].equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(arr[index]));
        root.left=go();
        root.right=go();
        return root;
    }
}