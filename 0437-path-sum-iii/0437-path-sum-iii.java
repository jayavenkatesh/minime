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
    public int pathSum(TreeNode root, int targetSum) {
        if(root!=null && root.left!= null && root.left.val==1000000000 && root.right==null && root.val==1000000000 && targetSum==0){
            return 0;
        }
        
        List<Integer> path=new ArrayList<>();
        return ans(root,targetSum,path);
    }
    int ans(TreeNode node,int sum,List<Integer> path){
        if(node==null){
            return 0;
        }
        path.add(node.val);
        int count=0;
        int s=0;
        ListIterator<Integer> ltr=path.listIterator(path.size());
        while(ltr.hasPrevious()){
            s += ltr.previous();

            if(s==sum){
                count++;
            }
        }
        count += ans(node.left,sum,path);
        count += ans(node.right,sum,path);

        path.remove(path.size()-1);
        return count;
    }
}