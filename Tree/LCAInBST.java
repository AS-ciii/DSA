package Tree;

class Solution {
    Node LCA(Node root, Node n1, Node n2) {
     if(root==null) return null;
     
     if(root.data == n1.data || root.data == n2.data) return root;
     
     if(root.data > n1.data && root.data > n2.data) return LCA(root.left, n1, n2);
     
     if(root.data < n1.data && root.data < n2.data) return LCA(root.right, n1, n2);
     
     return root;
    }
}
