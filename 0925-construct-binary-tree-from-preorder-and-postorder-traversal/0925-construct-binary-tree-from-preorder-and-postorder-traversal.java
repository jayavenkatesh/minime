/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int postpreindex = 0;
    HashMap<Integer, Integer> map;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        map = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            map.put(post[i], i);
        }
        return helper(pre, post, 0, post.length - 1);
    }
    private TreeNode helper(int[] preorder, int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[postpreindex++]);
        if (start == end) {
            return root;
        }
        int index = map.get(preorder[postpreindex]);
        root.left = helper(preorder, postorder, start, index);
        root.right = helper(preorder, postorder, index + 1, end - 1);
        return root;
    }
}