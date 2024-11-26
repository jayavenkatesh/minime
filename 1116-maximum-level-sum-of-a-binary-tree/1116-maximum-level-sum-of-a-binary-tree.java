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
    public int maxLevelSum(TreeNode root) {
        int ans=Integer.MIN_VALUE;
        Queue<TreeNode> queue=new LinkedList();
        queue.offer(root);
        int a=0;
        int level=1;
        while(!queue.isEmpty()){
            int n=queue.size();
            int val=0;
            while(n>0){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                val+=node.val;
                n--;
            }
            if(val>ans){
                a=level;
            }
            ans=Math.max(ans,val);
            level++;
        }
        return a;
    }
}