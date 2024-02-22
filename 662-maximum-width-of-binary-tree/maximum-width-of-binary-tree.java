import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        root.val = 0; // Assigning position to the root
        
        int maxWidth = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int leftmost = 0; // Position of the leftmost node at current level
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int pos = node.val; // Position of the current node
                
                if (i == 0) leftmost = pos; // Update leftmost position
                
                if (node.left != null) {
                    node.left.val = 2 * pos; // Position of left child
                    queue.offer(node.left);
                }
                
                if (node.right != null) {
                    node.right.val = 2 * pos + 1; // Position of right child
                    queue.offer(node.right);
                }
                
                // Calculate the width at current level
                maxWidth = Math.max(maxWidth, pos - leftmost + 1);
            }
        }
        
        return maxWidth;
    }
}
