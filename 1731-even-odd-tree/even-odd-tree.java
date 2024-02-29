import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    class Pair {
        TreeNode node;
        int lvl;
        
        Pair(TreeNode node, int lvl) {
            this.node = node;
            this.lvl = lvl;
        }
    }
    
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null || root.val % 2 == 0)
            return false;
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        
        while (!q.isEmpty()) {
            List<Integer> same = new ArrayList<>();
            int size = q.size();
            boolean oddLevel = false;
            
            for (int i = 0; i < size; i++) {
                Pair temp = q.poll();
                same.add(temp.node.val);
                int lvl = temp.lvl;
                
                if (lvl % 2 == 0)
                    oddLevel = true;
                
                if (temp.node.left != null)
                    q.offer(new Pair(temp.node.left, lvl + 1));
                if (temp.node.right != null)
                    q.offer(new Pair(temp.node.right, lvl + 1));
            }
            
            if (oddLevel) {
                if (!isStrictlyIncreasing(same) || !isOdd(same))
                    return false;
            } else {
                if (!isStrictlyDecreasing(same) || !isEven(same))
                    return false;
            }
        }
        
        return true;
    }
    
    private boolean isStrictlyIncreasing(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1))
                return false;
        }
        return true;
    }
    
    private boolean isStrictlyDecreasing(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) >= list.get(i - 1))
                return false;
        }
        return true;
    }
    
    private boolean isOdd(List<Integer> list) {
        for (int num : list) {
            if (num % 2 == 0)
                return false;
        }
        return true;
    }
    
    private boolean isEven(List<Integer> list) {
        for (int num : list) {
            if (num % 2 != 0)
                return false;
        }
        return true;
    }
}
