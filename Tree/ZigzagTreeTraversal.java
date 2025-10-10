class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        if (root == null) {
            return ans;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;
        while (!q.isEmpty()) {
            int size = q.size();
            Integer[] level = new Integer[size];
            
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                int index = leftToRight ? i : size - 1 - i;
                level[index] = node.data;
                
                if (node.left != null)
                    q.offer(node.left);
                    
                if (node.right != null)
                    q.offer(node.right);
            }
            
            leftToRight = !leftToRight;
            ans.addAll(Arrays.asList(level));
        }
        
        return ans;
    }
}
