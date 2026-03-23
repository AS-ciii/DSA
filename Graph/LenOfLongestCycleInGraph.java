class Solution {
    void solve(List<List<Integer>> adj, int node, int[] vis, int[] pathvis, int[] timer, int t, int[] max) {
        vis[node] = 1;
        pathvis[node] = 1;
        timer[node] = t;

        for(int nxt : adj.get(node)){
            if(vis[nxt] == 0){
                solve(adj, nxt, vis, pathvis, timer, t + 1, max);
            }else if(pathvis[nxt] == 1){
                max[0] = Math.max(max[0], t - timer[nxt] + 1);
            }
        }
        pathvis[node] = 0;
    }

    public int longestCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
        }

        int[] vis = new int[V + 1];
        int[] pathvis = new int[V + 1];
        int[] timer = new int[V + 1];
        Arrays.fill(timer, -1);

        int max1 = -1;

        for(int i = 0; i <= V; i++){
            if (vis[i] == 0) {
                int[] max = new int[]{-1};
                solve(adj, i, vis, pathvis, timer, 0, max);
                max1 = Math.max(max1, max[0]);
            }
        }
        return max1;
    }
}
