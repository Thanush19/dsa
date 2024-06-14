class Solution {
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node)) { // 1st hash calculation and method call, JVM faces overheads to create new stack frame in the stack memory of current thread
            return visited.get(node); // 2nd hash calculation and method call, JVM faces same overheads again
        }
        Node clone = new Node(node.val);
        visited.put(node, clone);
        for (Node e : node.neighbors) {
            clone.neighbors.add(cloneGraph(e));
        }
        return clone;
    }
}