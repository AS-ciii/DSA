/*
class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    
    PriorityQueue<Integer> pq=new PriorityQueue<>();

    public int kthSmallest(Node root, int k) {
        // code here
        trav(root);
        if(k > pq.size()) return -1;
        while(k-- > 1) pq.poll();
        return pq.peek();
    }
    
    void trav(Node root)
    {
        if(root == null) return;
        trav(root.left);
        pq.add(root.data);
        trav(root.right);
    }
}
