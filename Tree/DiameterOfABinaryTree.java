package Tree;

class Solution {
    int res = 0;
    int diameter(Node root) {
        calc(root);
        return res;
    }
    int calc(Node root) {
        if(root==null) return 0;
        
        int left = calc(root.left);
        int right = calc(root.right);
        res = Math.max(res, left+right);
        return Math.max(left, right)+1;
    }
}
