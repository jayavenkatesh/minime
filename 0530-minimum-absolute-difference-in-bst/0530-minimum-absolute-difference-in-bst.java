/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode prev;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        prev = null;
        inorder(root);
        return min;
    }
    
    void inorder(TreeNode root) {
        if(root == null) return;
        
        inorder(root.left);
        
        if(prev!=null) min = Math.min(min, Math.abs(prev.val- root.val));
        prev = root;
        
        inorder(root.right);
    }
}