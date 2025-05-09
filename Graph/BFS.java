class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfsTraversal = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        
        q.add(0);
        visited[0] = true;
        
        while(!q.isEmpty()) {
            int node = q.poll();
            bfsTraversal.add(node);
            
            for(int n : adj.get(node)) {
                if(!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
        
        return bfsTraversal;
        
    }
}
