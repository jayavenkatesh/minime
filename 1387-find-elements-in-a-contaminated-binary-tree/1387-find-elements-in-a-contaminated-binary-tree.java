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
    Set<Integer> hs=new HashSet();
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
        hs.add(node.val);
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
        if(hs.contains(target)) return true;
        return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */