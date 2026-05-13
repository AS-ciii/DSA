class Solution {
    
    public int findMotherVertex(int V, int[][] edges) {
        // code here
        
        //idea here is will do the dfs search from the given vertex and 
        //while selecting the given vertex will check all other vertex can be visited or not
        
        //build the graph
        
        @SuppressWarnings("unchecked")
        List<Integer>[]adj = new ArrayList[V];
        
        for(int i = 0; i < V; i++){
            
            adj[i] = new ArrayList<>();
            
        }
        
        for(int[]edge : edges){
            
            int u = edge[0];
            int v = edge[1];
            
            adj[u].add(v);
            
        }
        
        boolean[]visited = new boolean[V];
        
        int candidate = -1;
        
        for(int i = 0; i < V; i++){
            
            if(!visited[i]){
                
                dfs(i,adj,visited);
                
                candidate = i;
                
            }
            
        }
        
        Arrays.fill(visited,false);
        
        dfs(candidate,adj,visited);
        
        for(int i = 0; i < V; i++){
            
            if(!visited[i]) return -1;
            
        }
        
        return candidate;
        
    }
    
    private void dfs(int u, List<Integer>[]adj, boolean[]visited){
        
        visited[u] = true;
        
        for(int v : adj[u]){
            
            if(!visited[v]){
                
                dfs(v,adj,visited);
                
            }
            
        }
        
    }
    
}
