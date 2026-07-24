/**
 * Time : O(N) - since each node is processed exactly once.
 * Space :O(N) - to keep the output structure which contains N node values.
 **/
class Solution {
    List<List<Integer>> levels = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return levels;
        }
        Deque<TreeNode> deq = new ArrayDeque<>();
        deq.add(root);
        while (!deq.isEmpty()) {
            int size = deq.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deq.poll();
                level.add(node.val);
                if (node.left != null) {
                    deq.offer(node.left);
                }
                if (node.right != null) {
                    deq.offer(node.right);
                }
            }
            levels.add(level);
        }
        return levels;
    }
}