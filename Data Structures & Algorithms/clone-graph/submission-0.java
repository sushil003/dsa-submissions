/**
Time Complexity: O(N+M), where N is a number of nodes (vertices) and MMM is a number of edges.
Space Complexity: O(N). This space is occupied by the visited hash map and in addition to that, space would also be occupied by the recursion stack since we are adopting a recursive approach here. The space occupied by the recursion stack would be equal to O(H) where H is the height of the graph. Overall, the space complexity would be O(N).
 */
class Solution {
    public Node cloneGraph(Node node) {
        return cloneGraph(node, new HashMap<Node, Node>());
    }

    private Node cloneGraph(Node node, Map<Node, Node> map) {
        if (node == null) {
            return node;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node root = new Node(node.val, new ArrayList<>());
        map.put(node, root);
        for (Node n : node.neighbors) {
            root.neighbors.add(cloneGraph(n, map));
        }
        return root;
    }
}