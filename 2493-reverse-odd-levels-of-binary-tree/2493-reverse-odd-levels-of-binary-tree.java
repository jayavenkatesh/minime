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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root==null){
            return root;
        }
        Queue<TreeNode> queue=new LinkedList();
        queue.offer(root);
        int count=1;
        while(!queue.isEmpty()){
            if(queue.peek().left==null){
                break;
            }
            int n=queue.size();
            List<TreeNode> list=new ArrayList();
            for(int i=0;i<n;i++){
                list.add(queue.poll());
            }
            if(count%2==1){
                List<Integer> baby=new ArrayList();
                for(int i=0;i<n;i++){
                    TreeNode node=list.get(i);
                    baby.add(node.left.val);
                    baby.add(node.right.val);
                }
                int k=baby.size()-1;
                for(int i=0;i<n;i++){
                    TreeNode node=list.get(i);
                    node.left.val=baby.get(k);
                    node.right.val=baby.get(k-1);
                    k=k-2;
                }
            }
            for(int i=0;i<n;i++){
                TreeNode node=list.get(i);
                queue.add(node.left);
                queue.add(node.right);
            }
            count++;
        }
        return root;
    }
}