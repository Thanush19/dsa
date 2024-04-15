import java.util.*;

class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }
    
    private int sumNumbersHelper(TreeNode node, int currentSum) {
        if (node == null) return 0;
        
        // Calculate the sum so far along the current path
        int newSum = currentSum * 10 + node.val;
        
        // If the current node is a leaf node, return its contribution to the total sum
        if (node.left == null && node.right == null) {
            return newSum;
        }
        
        // Recursively calculate sum for left and right subtrees
        int leftSum = sumNumbersHelper(node.left, newSum);
        int rightSum = sumNumbersHelper(node.right, newSum);
        
        // Return the sum of sums from left and right subtrees
        return leftSum + rightSum;
    }
}
