/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    Node removekeys(Node root, int l, int r) {
        // code here
         if (root == null)
            return null;
        
        if (root.data < l)
            return removekeys(root.right, l, r);

        if (root.data > r)
            return removekeys(root.left, l, r);

        root.left = removekeys(root.left, l, r);
        root.right = removekeys(root.right, l, r);

        return root;
    }
}
