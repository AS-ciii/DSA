package Tree;

class Solution {
    
    public static Node buildTree(int inorder[], int preorder[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++) map.put(inorder[i], i);
        index = 0;
        return builder(preorder, inorder, 0, inorder.length-1, map);
    }
    
    static int index; 
    
    public static Node builder(int[] preorder, int[] inorder, int start, int end, HashMap<Integer, Integer> map) {
        if(start>end) return null;
        
        
        int rootVal = preorder[index++];
        Node root = new Node(rootVal);
        
        int ioindex = map.get(rootVal);
        
        root.left = builder(preorder, inorder, start, ioindex-1, map);
        root.right = builder(preorder, inorder, ioindex+1, end, map);
        
        return root;
    }
}

