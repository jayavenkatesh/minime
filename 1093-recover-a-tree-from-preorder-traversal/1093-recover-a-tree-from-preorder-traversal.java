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
    public TreeNode recoverFromPreorder(String t) {
        Stack<TreeNode> st = new Stack<>();
        int i = 0;
        while (i < t.length()) {
            int depth = 0;
            while (i < t.length() && t.charAt(i) == '-') {
                depth++;
                i++;
            }
            int value = 0;
            while (i < t.length() && Character.isDigit(t.charAt(i))) {
                value = value * 10 + (t.charAt(i) - '0');
                i++;
            }
            TreeNode node = new TreeNode(value);
            while (st.size() > depth) {
                st.pop();
            }
            if (!st.isEmpty()) {
                if (st.peek().left == null) {
                    st.peek().left = node;
                } else {
                    st.peek().right = node;
                }
            }
            st.push(node);
        }
        while (st.size() > 1) {
            st.pop();
        }
        return st.peek();
    }
}
