/*
class Node{
    int data;
    Node left, right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    long max, min = Integer.MIN_VALUE;
    int findMaxSum(Node root) {
        // code here
        max = (long)Integer.MIN_VALUE;
        findMaxSum2(root);
        return (int)max;
    }
    long findMaxSum2(Node root){
        if(root == null){
            return min;
        }
        long left = findMaxSum2(root.left);
        long right = findMaxSum2(root.right);
        
        long max2 = Math.max((long)root.data,Math.max((long)root.data+left,(long)root.data+right));
        max = Math.max(max,Math.max(max2,Math.max(left,Math.max(right,left+right+(long)root.data))));
    
        return max2;
    }
}

