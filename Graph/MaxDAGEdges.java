class Solution {
    public int maxEdgesToAdd(int V, int[][] edges) {
        // Code here
        int n = edges.length;
        boolean[][] vis = new boolean[V][V];
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[V];
        int[] topo = new int[V];
        int[] indeg = new int[V];
        
        for(int i = 0; i < V; i++) graph[i] = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            vis[edges[i][0]][edges[i][1]] = true;
            indeg[edges[i][1]]++;
            graph[edges[i][0]].add(edges[i][1]);
        } 
       
        topoSort(topo,graph,indeg,V);
       
        int count = 0;
        
        for(int i = 0; i < V; i++){
            for(int j = i+1; j < V; j++){
                if(!vis[topo[i]][topo[j]]) count++;
            }
        }
        
        return count;
    }
    private void topoSort(int[] topo, ArrayList<Integer>[] graph, int[] indeg, int V){
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < V; i++) if(indeg[i] == 0) q.add(i);
        
        int idx = 0;
        
        while(!q.isEmpty()){
            int rem = q.remove();
            topo[idx++] = rem;
            
            for(int el : graph[rem]){
                indeg[el]--;
                if(indeg[el] == 0) q.add(el);
            }
        }
    }
}
