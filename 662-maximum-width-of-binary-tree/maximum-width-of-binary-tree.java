class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(1, 0, root)); // num, level, node
        int prevNum = 1, prevLevel = 0;
        int res = 0;

        while(!q.isEmpty()) {
            Tuple curr = q.remove();
            int num = curr.num, level = curr.level;
            TreeNode node = curr.node;

            if(prevLevel < level) {
                prevLevel = level;
                prevNum = num;
            }

            res = Math.max(res, num - prevNum +1);

            if(node.left != null) {
                q.add(new Tuple(num*2, level+1, node.left));
            } if(node.right != null) {
                q.add(new Tuple(num*2+1, level+1, node.right));
            }
        }

        return res;
    }

    class Tuple {
        int num;
        int level;
        TreeNode node;

        Tuple(int num, int level, TreeNode node) {
            this.num = num;
            this.level = level;
            this.node = node;
        }
    }
}