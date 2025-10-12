/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    int count = 0;
    
    public int dfs(Node root){
        if(root == null){
            return 0;
        }
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        count += Math.abs(left) + Math.abs(right);
        
        return root.data -1 + left + right;
    }
    
    public int distCandy(Node root) {
        // code here
        dfs(root);
        return count;
    }
}
