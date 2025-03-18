package Tree;

class Solution {
    // Function to find the height of a binary tree.
    int height(Node node) {
        Queue<Node> queue = new LinkedList<>();
        int height = 0;
        
        ArrayList<ArrayList> res = new ArrayList<>();
        queue.offer(node);
        
        while(!queue.isEmpty()) {
            int len = queue.size();
            res.add(new ArrayList<>());
            
            for(int i=0; i<len; i++) {
                Node curr = queue.poll();
                res.get(height).add(curr.data);
                
                if(curr.left!=null) {
                    queue.offer(curr.left);
                }
                
                if(curr.right!=null) {
                    queue.offer(curr.right);
                }
            }
            height++;
        }
        
        return height-1;
    }
}
