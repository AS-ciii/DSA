package Tree;

class Solution {
    
    Node first, mid, last, prev;
    
    void correctBST(Node root) {
        first = mid = last = prev = null;
        inorder(root);
        
        if(first!=null && last!=null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else if(first!=null && mid!=null) {
            int temp = first.data;
            first.data = mid.data;
            mid.data = temp;
        }
    }
    
    void inorder(Node node) {
        if(node==null) return;
        
        inorder(node.left);
        if(prev!=null && node.data < prev.data) {
            if(first==null) {
                first = prev;
                mid = node;
            } else last = node;
        }
        
        prev = node;
        inorder(node.right);
    }
}

