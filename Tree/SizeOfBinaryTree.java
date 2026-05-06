/*
Definition for Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Solution {
    public int getSize(Node root) {
        // Base Case
        if(root == null) {
            return 0;
        }
        
        // Recursion call to left & right
        int ans = 1 + getSize(root.left) + getSize(root.right);
        
        return ans;
    }
}
