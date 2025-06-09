/*
class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
}*/

class Solution {
    public boolean isDeadEnd(Node root) {
        // Code here.
        return helper(root , 0 , Integer.MAX_VALUE);
    }
    public static boolean helper(Node root , int min , int max){
        if(root == null){
            return false;
        }
        if(min+1 == root.data && max-1 == root.data){
            return true;
        }
        return helper(root.left , min , root.data) || helper(root.right , root.data ,max);
    }
}
