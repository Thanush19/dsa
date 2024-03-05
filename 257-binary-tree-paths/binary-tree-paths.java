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

    private List<String> paths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {        
        if (root != null) {
           dfsFindLeafsAndAddToResult(root, new StringBuilder()); 
        }
        return paths;
    }

    private void dfsFindLeafsAndAddToResult(TreeNode root, StringBuilder sb) {
        checkRootIsNotNullAndAddValueToPath(root, sb);
        if (root.left != null && root.right != null) {
            splitPathIntoTwoPaths(root, sb);
        } else {
            if (root.left != null) {
                dfsFindLeafsAndAddToResult(root.left, sb.append("->"));
            } else {
                if (root.right != null) {
                    dfsFindLeafsAndAddToResult(root.right, sb.append("->")); 
                } else {
                    paths.add(sb.toString());
                }
            }
        }
    }

    private void checkRootIsNotNullAndAddValueToPath(TreeNode root, StringBuilder sb) {
        if (root != null) {
            sb.append(root.val);
        }
    }

    private void splitPathIntoTwoPaths(TreeNode root, StringBuilder sb) {
        sb.append("->");
        dfsFindLeafsAndAddToResult(root.left, new StringBuilder(sb.toString()));
        dfsFindLeafsAndAddToResult(root.right, new StringBuilder(sb.toString()));
    }
}