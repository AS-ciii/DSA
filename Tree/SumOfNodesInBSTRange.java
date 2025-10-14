/*
class Node {
  public:
    int data;
    Node* left;
    Node* right;

    // Constructor to initialize a new node
    Node(int val) {
        data = val;
        left = NULL;
        right = NULL;
    }
};
*/

class Solution {
    public int nodeSum(Node root, int l, int r) {
        
        if (root == null) {
            return 0;
        }
        
        int sum = 0;
        
        if (root.data >= l && root.data <= r) {
            sum += root.data;
        }
        
        
        if (root.data > l) {
            sum += nodeSum(root.left, l, r);    
        }
        
        // right subtree might have valid nodes only when current node's value is 
        // less than the r
        if (root.data < r) {
            sum += nodeSum(root.right, l, r);   
        }
        
        return sum;
    }
}
