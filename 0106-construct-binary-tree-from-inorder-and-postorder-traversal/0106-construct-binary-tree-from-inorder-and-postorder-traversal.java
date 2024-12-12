class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, 
                                     int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        
        int leftTreeSize = rootIndex - inStart;
        
        root.left = buildTreeHelper(inorder, inStart, rootIndex - 1, 
                                    postorder, postStart, postStart + leftTreeSize - 1);
        root.right = buildTreeHelper(inorder, rootIndex + 1, inEnd, 
                                     postorder, postStart + leftTreeSize, postEnd - 1);
        
        return root;
    }
}
