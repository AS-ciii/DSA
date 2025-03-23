package Tree;

class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> res = new ArrayList<>();
        if(node == null) return res;
        
        
        if(!isLeaf(node)) res.add(node.data);
        addLeftB(node.left, res);
        addLeaves(node, res);
        addRightB(node.right, res);
        
        return res;
    }
    
    private void addLeftB(Node node, ArrayList<Integer> res) {
        while(node!=null) {
            if(!isLeaf(node)) res.add(node.data);
            node = (node.left!=null)?node.left:node.right;
        }
    }
    
    private void addRightB(Node node, ArrayList<Integer> res) {
        Stack<Integer> stack = new Stack<>();
        
        while(node!=null) {
            if(!isLeaf(node)) stack.push(node.data);
            node = (node.right!=null)?node.right:node.left;
        }
        
        while(!stack.isEmpty()) res.add(stack.pop());
    }
    
    private void addLeaves(Node node, ArrayList<Integer> res) {
        if(node==null) return;
        if(isLeaf(node)) {
            res.add(node.data);
            return;
        }
        addLeaves(node.left, res);
        addLeaves(node.right, res);
    }
    
    private boolean isLeaf(Node node) {
        return node.left==null&&node.right==null;
    }
}
