import java.util.*;

class Solution {
    // Define a Tuple class to store node, vertical position, and level
    class Tuple {
        TreeNode node;
        int ver, lvl;
        Tuple(TreeNode n, int v, int l) {
            node = n;
            ver = v;
            lvl = l;
        }
    }

    // Method to perform vertical traversal of the binary tree
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Initialize the result list
        List<List<Integer>> ans = new ArrayList<>();
        // If the root is null, return an empty result
        if (root == null) return ans;

        // Create a TreeMap to store nodes sorted by vertical and level positions
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
        // Create a queue for level-order traversal
        Queue<Tuple> q = new LinkedList<>();
        // Add the root node to the queue with vertical and level positions initialized to 0
        q.offer(new Tuple(root, 0, 0));

        // Perform level-order traversal of the binary tree
        while (!q.isEmpty()) {
            int n = q.size();
            // Process nodes at the current level
            for (int i = 0; i < n; i++) {
                Tuple t = q.poll();
                TreeNode node = t.node;
                int ver = t.ver;
                int lvl = t.lvl;

                // Update the TreeMap with the current node
                mp.putIfAbsent(ver, new TreeMap<>());
                mp.get(ver).putIfAbsent(lvl, new PriorityQueue<>());
                mp.get(ver).get(lvl).offer(node.val);

                // Add left child to the queue with adjusted vertical and level positions
                if (node.left != null) {
                    q.offer(new Tuple(node.left, ver - 1, lvl + 1));
                }
                // Add right child to the queue with adjusted vertical and level positions
                if (node.right != null) {
                    q.offer(new Tuple(node.right, ver + 1, lvl + 1));
                }
            }
        }

        // Build the result list from the TreeMap
        for (Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> e : mp.entrySet()) {
            List<Integer> temp = new ArrayList<>();
            // Iterate over PriorityQueue values (nodes at the same vertical and different levels)
            for (PriorityQueue<Integer> pq : e.getValue().values()) {
                // Extract nodes from PriorityQueue and add to the temporary list
                while (!pq.isEmpty()) {
                    temp.add(pq.poll());
                }
            }
            // Add the temporary list to the result list
            ans.add(temp);
        }

        // Return the result list containing nodes in vertical order
        return ans;
    }
}
