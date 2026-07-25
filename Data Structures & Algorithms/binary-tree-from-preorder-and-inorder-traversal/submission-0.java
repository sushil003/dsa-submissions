class Solution {
    int preOrderIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, inorder.length - 1, map);
    }
    private TreeNode buildTree(int[] preorder, int[] inorder, int start, int end, Map<Integer, Integer> map) {
        if (start > end) {
            return null;
        }
        int preOrderVal = preorder[preOrderIdx++];
        int inOrderIdx = map.get(preOrderVal);
        TreeNode root = new TreeNode(preOrderVal);
        root.left = buildTree(preorder, inorder, start, inOrderIdx - 1, map);
        root.right = buildTree(preorder, inorder, inOrderIdx + 1, end, map);
        return root;
    }
}