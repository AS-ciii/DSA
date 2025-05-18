class Solution {
    public ArrayList<Integer> findSpiral(Node root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        boolean dir = false;
        
        while(!que.isEmpty()){
            int n = que.size();
            int row[] = new int[n];
            
            for(int i=0 ; i<n ;i++){
                Node node = que.poll();
                
                int idx = (dir) ? i : (n-1-i);
                row[idx]= node.data;
                
                if(node.left != null){
                    que.add(node.left);
                }
                
                if(node.right != null){
                    que.add(node.right);
                }
            }
            
            for(int val : row){
                res.add(val);
            }
            
            dir = !dir;
        }
        return res;
        
    }
}
