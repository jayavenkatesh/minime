/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        Queue<Node> queue=new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            //Node t=new Node();
            for(int i=0;i<n;i++){
                Node a=queue.poll();
                
                if(a.left!=null){
                    queue.offer(a.left);
                }
                if(a.right!=null){
                    queue.offer(a.right);
                }
                if(i==n-1){
                    a.next=null;
                }
                else{
                    a.next=queue.peek();
                    a=a.next;
                }
            }
        }
        return root;
    }
}