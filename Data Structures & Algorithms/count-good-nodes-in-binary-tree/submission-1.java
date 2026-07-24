class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root,root.val);
    }
    private int dfs(TreeNode root,int max) {
        if(root == null) {
            return 0;
        }
        max = Math.max(max,root.val);
        return (root.val >= max ? 1 : 0) + dfs(root.left,max) + dfs(root.right,max);
    }
}