class Solution {
    
    public void dfs(int curr, ArrayList<ArrayList<Integer>> adj, boolean vis[]){
        vis[curr] = true;
        
        for(int i=0; i<adj.get(curr).size(); i++){
            int neigh = adj.get(curr).get(i);
            if(!vis[neigh]){
                dfs(neigh, adj, vis);
            }
        }
    }
    
    public int minConnect(int V, int[][] edges) {
        // code here
        
        if (edges.length < V - 1) return -1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int count = -1;
        
        boolean vis[] = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(i, adj, vis);
                count++;
            }
        }
        
        return count;
    }
}
