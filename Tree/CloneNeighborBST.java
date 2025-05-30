/*
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
} */
class Solution {
    public int findMaxFork(Node root, int k) {
        // code here.
        if(root==null)return -1;
        if(root.data==k)return k;
        int left = -1;
        if(root.left != null && root.data > k){
            left = findMaxFork(root.left,k);
        }
        int right = -1;
        if(root.right != null && root.data < k){
            right = findMaxFork(root.right,k);
        }
        
        if(root.data <k){
            return Math.max(root.data,Math.max(left,right));
        }
        else{
            return Math.max(left,right);
        }
    }
}
