class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<Integer>());
        for(int[] pre: prerequisites) {
            int v = pre[0];
            int u = pre[1];
            
            adj.get(u).add(v);
        }
        
        if(findCycle(n, adj)) return false;
        return true;
    }
    
    private boolean findCycle(int n, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] vis = new boolean[n];
        boolean[] path = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                if(dfs(i, adj, vis, path)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(
        int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] path
    ) {
        vis[node] = true;
        path[node] = true;
        
        for(int adjNode: adj.get(node)) {
            if(!vis[adjNode]) {
                if(dfs(adjNode, adj, vis, path)) return true;
            }
            else if(path[adjNode]) return true;
        }
        
        path[node] = false;
        return false;
    }
}
