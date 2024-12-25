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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largestValueInEachRow=new ArrayList();
        if(root==null){
            return largestValueInEachRow;
        }
        Queue<TreeNode> queue=new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            int val=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                TreeNode node=queue.poll();
                val=Math.max(val,node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            largestValueInEachRow.add(val);
        }
        return largestValueInEachRow;
    }
}