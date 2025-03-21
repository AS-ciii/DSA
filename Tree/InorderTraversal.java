package Tree;

class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
    
    private void dfs(Node node, ArrayList<Integer> res) {
        if(node==null) return;
        
        dfs(node.left, res);
        res.add(node.data);
        dfs(node.right, res);
    }
}
