public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        Deque<String> queue = new ArrayDeque<>();
        queue.addAll(Arrays.asList(data_array));
        return helper(queue);
    }

    private TreeNode helper(Deque<String> queue) {
        String curr = queue.poll();
        if ("null".equals(curr))  return null;
        TreeNode root = new TreeNode(Integer.parseInt(curr));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }
}