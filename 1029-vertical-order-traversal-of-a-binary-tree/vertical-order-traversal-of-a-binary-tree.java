import java.util.*;

class Solution {
    class Tuple {
        TreeNode node;
        int ver, lvl;
        Tuple(TreeNode n, int v, int l) {
            node = n;
            ver = v;
            lvl = l;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Tuple t = q.poll();
                TreeNode node = t.node;
                int ver = t.ver;
                int lvl = t.lvl;

                mp.putIfAbsent(ver, new TreeMap<>());
                mp.get(ver).putIfAbsent(lvl, new PriorityQueue<>());
                mp.get(ver).get(lvl).offer(node.val);

                if (node.left != null) {
                    q.offer(new Tuple(node.left, ver - 1, lvl + 1));
                }
                if (node.right != null) {
                    q.offer(new Tuple(node.right, ver + 1, lvl + 1));
                }
            }
        }

        for (Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> e : mp.entrySet()) {
            List<Integer> temp = new ArrayList<>();
            for (PriorityQueue<Integer> pq : e.getValue().values()) {
                while (!pq.isEmpty()) {
                    temp.add(pq.poll());
                }
            }
            ans.add(temp);
        }

        return ans;
    }
}
