class Solution {
    
    private static int time;
    private static ArrayList<Integer> result;
    
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] visited = new boolean[V];
        boolean[] ap = new boolean[V];
        Arrays.fill(parent, -1);

        time = 0;
        result = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited, disc, low, parent, ap);
            }
        }

        for (int i = 0; i < V; i++) {
            if (ap[i]) result.add(i);
        }

        if (result.isEmpty()) 
            return new ArrayList<>(Arrays.asList(-1));
        return result;
    }
    
    private static void dfs(int u, ArrayList<ArrayList<Integer>> graph, boolean[] visited,
                     int[] disc, int[] low, int[] parent, boolean[] ap) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : graph.get(u)) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                dfs(v, graph, visited, disc, low, parent, ap);

                low[u] = Math.min(low[u], low[v]);

                // Root case
                if (parent[u] == -1 && children > 1) ap[u] = true;

                // Non-root case
                if (parent[u] != -1 && low[v] >= disc[u]) ap[u] = true;
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]); // back edge
            }
        }
    }
}
