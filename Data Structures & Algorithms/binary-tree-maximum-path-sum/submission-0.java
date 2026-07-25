class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGains(root);
        return maxSum;
    }
    private int maxGains(TreeNode root) {
        if (root == null)  return 0;
        int leftGain = Math.max(maxGains(root.left), 0);
        int rightGain = Math.max(maxGains(root.right), 0);
        maxSum = Math.max(maxSum, root.val + leftGain + rightGain);
        return root.val + Math.max(leftGain, rightGain);
    }
}