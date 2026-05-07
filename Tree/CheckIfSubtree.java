/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/
class Solution {
      public boolean isSubTreeEqual(Node root1, Node root2) {
        // Base Case
        // Both null
        if(root1 == null && root2 == null) {
            return true;
        }
        // Anyone one is null or data isnt matching
        if(root1 == null || root2 == null || root1.data != root2.data) {
            return false;
        }
        
        // Matching left & right
        return isSubTreeEqual(root1.left, root2.left) && isSubTreeEqual(root1.right, root2.right);
    }
    
    public boolean isSubTree(Node root1, Node root2) {
        // Base Case
        if(root1 == null ) {
            return false;
        }
        // Matching data and subtree
        if(root1.data == root2.data && isSubTreeEqual(root1, root2)) {
            return true;
        }
        
        // Checking left & right
        return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
    }
}
