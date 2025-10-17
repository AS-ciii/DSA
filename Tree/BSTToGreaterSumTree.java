class Solution {
    
    static int sum = 0;
    
    public static void transformTree(Node root) {
        // code here
        sum = 0;
        // sum is a static var => class var
        // it satys in m/y as long as JVM keeps the class file loaded
        // As multiple TCs are run in 1 single execution of program,
        // The same static variable is used across all TCs.
        // So, we reset the variable every time we run the same program 
        // for each TC.
        
        helper(root);
    }
    
    static void helper(Node root){
        // inorder: left->root->right
        // inorder traversal of tree -> ascending order
        // reverse inorder traversal -> descending order
        if(root == null) return;
        helper(root.right);
        int temp = root.data;
        root.data = sum;
        sum+=temp;
        helper(root.left);
    }
}
