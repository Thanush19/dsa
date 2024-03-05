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
    
    class Pair {
        int lvl;
        int node;
        Pair(int lvl, int node) {
            this.lvl = lvl;
            this.node = node;
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> b.lvl - a.lvl);
        fn(root, q, 1);
        return q.poll().node;
    }

    int fn(TreeNode root, Queue<Pair> q, int lvl) {
        if (root == null)
            return 0;

        int l = fn(root.left, q, lvl + 1);
        int r = fn(root.right, q, lvl + 1);
        
        int currentLevel = Math.max(l, r) + 1;

        if (root.left == null && root.right == null) {
            q.offer(new Pair(lvl, root.val));
        }

        return currentLevel;
    }
}