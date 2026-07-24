/* Structure of Binary Tree Node
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
}*/
class Solution {
    static int ans;
    public int longestConsecutive(Node root) {
        ans = 1;
        solve(root);
        return ans == 1 ? -1 : ans;
        
    }
    private static int solve(Node root) {
        if(root == null) return 0;
        int left = solve(root.left);
        int right = solve(root.right);
        int cnt = 1;
        if(root.left != null && root.left.data == root.data+1) {
            cnt = Math.max(cnt, left+1);
        }
        if(root.right != null && root.right.data == root.data+1) {
            cnt = Math.max(cnt, right+1);
        }
        ans = Math.max(ans, cnt);
        return cnt;
        
    }
    
}
