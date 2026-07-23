class Solution {
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }
    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        res = Math.max(res, left + right);
        return 1 + Math.max(left, right);
    }
}
