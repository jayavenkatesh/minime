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
    HashMap<Integer,Integer> hm=new HashMap();
    public int[] findMode(TreeNode root) {
        List<Integer> list=new ArrayList();
        dfs(root);
        int max=0;
        for(Map.Entry<Integer,Integer> map:hm.entrySet()){
            if(map.getValue()>max){
                max=map.getValue();
            }
        }
        List<Integer> vals=new ArrayList();
        for(Map.Entry<Integer,Integer> map:hm.entrySet()){
            if(map.getValue()==max){
                vals.add(map.getKey());
            }
        }
        int[] arr=new int[vals.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=vals.get(i);
        }
        return arr;
    }
    void dfs(TreeNode node){
        if(node==null){
            return;
        }
        hm.put(node.val,hm.getOrDefault(node.val,0)+1);
        dfs(node.left);
        dfs(node.right);
    }
}