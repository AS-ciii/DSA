class Solution {
    public static ArrayList<Node> inOrderTrv(Node root,ArrayList<Node> inorder){
        if(root == null){
            return inorder;
        }
        inOrderTrv(root.left,inorder);
        inorder.add(root);
        inOrderTrv(root.right,inorder);
        return inorder;
        
    }
    public ArrayList<Node> findPreSuc(Node root, int key) {
        int predecessor  = Integer.MIN_VALUE;
        ArrayList<Node> inorder = new ArrayList<Node>();
        inOrderTrv(root,inorder);
        
        Node pre = null;
        Node suc = null;
        
         for (int i = 0; i < inorder.size(); i++) {
            if (inorder.get(i).data < key) {
                pre = inorder.get(i);
            } else if (inorder.get(i).data > key) {
                suc = inorder.get(i);
                break; 
            }
        }
        
        inorder.clear();
        inorder.add(pre);  
        inorder.add(suc); 
        
        return inorder; 
    }
}
