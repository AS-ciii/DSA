package Tree;

class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        if(root==null) return res;
        
        Queue<Node> visited = new LinkedList<>();
        
        visited.offer(root);
        
        while(!visited.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            
            Node curr = visited.poll();
            
            temp.add(curr.data);
            
            if(curr.left!=null) visited.offer(curr.left);
            if(curr.right!=null) visited.offer(curr.right);
            
            res.add(temp);
        }
        return res;
    }
}
