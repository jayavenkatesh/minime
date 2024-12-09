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
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        return Math.max(dfs(root.left, 1, false), dfs(root.right, 1, true));
    }

    private int dfs(TreeNode node, int length, boolean isRight) {
        if (node == null) {
            return length - 1;
        }
        int leftZigZag = dfs(node.left, isRight ? length + 1 : 1, false);
        int rightZigZag = dfs(node.right, !isRight ? length + 1 : 1, true);
        return Math.max(leftZigZag, rightZigZag);
    }
}
