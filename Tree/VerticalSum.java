/* Structure of binary tree node
class Node{
public:
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    TreeMap<Integer,Integer> map;
    public ArrayList<Integer> verticalSum(Node root) {
        map = new TreeMap<>();
        calculate(0,root);
        
        return new ArrayList<>(map.values());
    }
    
    public void calculate(int level, Node root){
        if(root == null)
            return;
            
        int previousVal = map.getOrDefault(level, 0);
        map.put(level , previousVal + root.data);
        
        calculate(level - 1 , root.left);
        calculate(level + 1 , root.right);
    }
}
