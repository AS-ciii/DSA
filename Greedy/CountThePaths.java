class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        // Code here
        int[] dp = new int[V];
        ArrayList<Integer>[] graph = new ArrayList[V];
        for(int i=0 ; i<V ; i++){
            graph[i] = new ArrayList<>();
            dp[i] = -1;
        }
        
        for(int i=0; i<edges.length ; i++){
            graph[edges[i][0]].add(edges[i][1]);
        }
        
        return dfs(graph,dp,src,dest);
    }
    int dfs(ArrayList<Integer>[] graph, int dp[], int src , int dest){
        if(src==dest) return 1;
        if(dp[src]!=-1) return dp[src];
        
        int count =0 ;
        for(int i=0 ; i<graph[src].size() ; i++){
            count += dfs(graph,dp, graph[src].get(i), dest);
        }
        return dp[src] = count;
    }
}
