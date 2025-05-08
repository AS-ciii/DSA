class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> s = new Stack<>();
        
        s.push(0);
        while(!s.isEmpty()) {
            int node = s.pop();
            if(!visited[node]) {
                visited[node] = true;
                res.add(node);
                
                List<Integer> n = adj.get(node);
                for(int i=n.size()-1; i>=0; i--) {
                    if(!visited[n.get(i)]) s.push(n.get(i));
                }
            }
        }
        
        return res;
        
    }
}
