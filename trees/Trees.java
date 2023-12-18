package trees;
import java.util.LinkedList;
import java.util.Queue;

public class Trees {
    // Definition of a tree node
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        // Constructor to initialize a tree node with data
        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Definition of a binary tree and tree-related operations
    static class BinaryTree {
        static int i = -1; // Static index for building the tree

        // Build a binary tree from an array
        public static TreeNode buildTree(int[] n) {
            i++;
            if (i >= n.length || n[i] == -1) {
                return null; // Base case: return null for empty or -1 nodes
            }
            TreeNode newNode = new TreeNode(n[i]);
            newNode.left = buildTree(n); // Recursively build left subtree
            newNode.right = buildTree(n); // Recursively build right subtree
            return newNode;
        }

        // Preorder traversal (Root -> Left -> Right)
        public static void preorder(TreeNode root) {
            if (root == null) return;
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        // Inorder traversal (Left -> Root -> Right)
        public static void inorder(TreeNode root) {
            if (root == null) return;
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        // Postorder traversal (Left -> Right -> Root)
        public static void postorder(TreeNode root) {
            if (root == null) return;
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        // Breadth-first (level order) traversal using a queue
        public static void bfs(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode temp = q.poll();
                System.out.print(temp.data + " ");

                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        public static int noOfNodes(TreeNode root){
            if(root==null) return 0;
            return noOfNodes(root.left)+noOfNodes(root.right)+1;
        }

        public static int sum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return root.data + sum(root.left) + sum(root.right);
        }
        public static int maxDepth(TreeNode root) {
            if (root == null)
            return 0;
        else {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(root.left);
            int rDepth = maxDepth(root.right);
 
            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
        }
        
        
        
    }

    // Main method to test tree operations
    public static void main(String[] args) {
        int[] n = {0, 1, 2};
        BinaryTree tree = new BinaryTree();
        TreeNode ans = tree.buildTree(n);

        // System.out.println("Preorder traversal");
        // BinaryTree.preorder(ans);
        // System.out.println();

        // System.out.println("Postorder traversal");
        // BinaryTree.postorder(ans);
        // System.out.println();

        // System.out.println("Inorder traversal");
        // BinaryTree.inorder(ans);

        // System.out.println("\nLevel order traversal");
        // BinaryTree.bfs(ans);
        // System.out.println("\n no. of nodes");

        // int numberOfNodes = BinaryTree.noOfNodes(ans);
        // System.out.println(numberOfNodes);
        
        // System.out.println("\nSum of nodes");
        // int sumOfNodes = BinaryTree.sum(ans);
        // System.out.println(sumOfNodes);

        int treeHeight = BinaryTree.maxDepth(ans);
        System.out.println("Height of the tree: " + treeHeight);
        
       
    }
}
