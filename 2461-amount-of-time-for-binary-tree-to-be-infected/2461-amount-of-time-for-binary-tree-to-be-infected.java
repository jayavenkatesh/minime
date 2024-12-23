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
    private Map<Integer, List<Integer>> hm = new HashMap<>();

    public int amountOfTime(TreeNode root, int start) {
        graph(root);
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
      
        queue.offer(start);
        int time = -1; 
      
        while (!queue.isEmpty()) {
            time++;
            int n=queue.size();
            for (int i = 0; i<n; i++) {
                int cur = queue.poll();
                visited.add(cur);
                if (hm.containsKey(cur)) {
                    for (int in : hm.get(cur)) {
                        if (!visited.contains(in)) {
                            queue.offer(in);
                        }
                    }
                }
            }
        }
        return time;
    }

    private void graph(TreeNode node) {
        if (node == null) {
            return;
        }
      
        if (node.left != null) {
            hm.computeIfAbsent(node.val, k -> new ArrayList<>()).add(node.left.val);
            hm.computeIfAbsent(node.left.val, k -> new ArrayList<>()).add(node.val);
        }
      
        if (node.right != null) {
            hm.computeIfAbsent(node.val, k -> new ArrayList<>()).add(node.right.val);
            hm.computeIfAbsent(node.right.val, k -> new ArrayList<>()).add(node.val);
        }
      
        
        graph(node.left);
        graph(node.right);
    }
}