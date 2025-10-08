/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public Node constructTree(int[] pre, int[] post) {
        // code here
        int n = pre.length;
        int[] left = new int[1_00_01];
        int[] right = new int[1_00_01];
        HashSet<Integer> hs = new HashSet<>();
        
        left[pre[n-1]] = -1;
        right[post[0]] = -1;
        hs.add(pre[0]);
        for(int i = 0, j = n-1; i < n-1; i++,j--){
            left[pre[i]] = pre[i+1];
            right[post[j]] = post[j-1];
        }
        
        Node root = new Node(pre[0]);
        
        constructTree2(root,pre[0],left,right,hs);
        
        return root;
    }
    private void constructTree2(Node root, int d, int[] left, int[] right, HashSet<Integer> hs){
        if(root == null) return;
        
        if(left[d] != -1 && !hs.contains(left[d])){
            root.left = new Node(left[d]);
            hs.add(left[d]);
        } 
        if(right[d] != -1 && !hs.contains(right[d])){
            root.right = new Node(right[d]);
            hs.add(right[d]);
        } 
        
        constructTree2(root.left,left[d],left,right,hs);
        constructTree2(root.right,right[d],left,right,hs);
    }
}
