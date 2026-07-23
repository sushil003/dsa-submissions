class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                res.addFirst(curr.val);
                curr = curr.right;
            } else {
                TreeNode node = stack.pop();
                curr = node.left;
            }
        }
        return res;
    }
}