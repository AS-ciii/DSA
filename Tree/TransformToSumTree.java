/* Structure for Tree Node
class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/
class Solution {
    public void toSumTree(Node root) {
        // code here
          sum(root);
        
    }
    
    public int sum(Node root){
        if(root==null)
            return 0;
            
        int left=sum(root.left);
        int right=sum(root.right);
        int data=root.data;
        root.data= left+right;
        return root.data+data;
    }
}
