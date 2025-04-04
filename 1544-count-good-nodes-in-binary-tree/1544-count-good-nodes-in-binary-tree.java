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
    int ans=0;
    public int goodNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int max=Integer.MIN_VALUE;
        dfs(root,max);
        return ans;
    }
    void dfs(TreeNode node,int max){
        if(node.val>=max){
            max=node.val;
            System.out.println(node.val);
            ans+=1;
        }
        if(node.left!=null) dfs(node.left,max);
        if(node.right!=null) dfs(node.right,max);
    }
}