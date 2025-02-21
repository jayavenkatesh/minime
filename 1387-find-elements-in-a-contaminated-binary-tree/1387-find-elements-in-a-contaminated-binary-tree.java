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
class FindElements {
    TreeNode groot;
    public FindElements(TreeNode root) {
        if(root!=null && root.val==-1){
            root.val=0;                
        }
        rec(root);   
        groot=root;  
    }
    void rec(TreeNode node){
        if(node==null){
            return;
        }

        if(node.left !=null){
            node.left.val=2*node.val+1;                
        }
        if(node.right !=null){
            node.right.val=2*node.val+2;
        }

        rec(node.left);
        rec(node.right);

    }
    
    public boolean find(int target) {
        TreeNode node=new TreeNode();
        node=groot;
        return findHelper(node, target);
    }
    boolean findHelper(TreeNode node, int target){
        if(node==null){
            return false;
        }
        if(node.val==target){
            return true;
        }
        
        if(findHelper(node.left, target) || findHelper(node.right, target)) return true;

        return false;
    }  
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */