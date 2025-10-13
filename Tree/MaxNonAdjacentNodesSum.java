/*
class Node {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    static Map<Node, Integer> m= new HashMap<>();
    
    public int getMaxSum(Node root) {
        // code here
        if(root==null) return 0;
        
        if(m.containsKey(root)) return m.get(root);
        
        int withoutNode=root.data;
        
        if(root.left!=null){
        withoutNode+=getMaxSum(root.left.left);
        withoutNode+=getMaxSum(root.left.right);
        }
        
        if(root.right!=null){
        withoutNode+=getMaxSum(root.right.left);
        withoutNode+=getMaxSum(root.right.right);
        }
        
        int withNode =(getMaxSum(root.left)+getMaxSum(root.right));
        
        
        int res =Math.max(withoutNode, withNode);
        m.put(root, res);
        
        return res;
        
        
    }
}
