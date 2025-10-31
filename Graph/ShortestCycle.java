class Solution {
    public int shortCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int ans = Integer.MAX_VALUE;
        for (int start = 0; start < V; start++) {
            int[] dist = new int[V];
            Arrays.fill(dist, -1);
            int[] parent = new int[V];
            Arrays.fill(parent, -1);
            Queue<Integer> q = new LinkedList<>();
            q.offer(start);
            dist[start] = 0;
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : adj.get(u)) {
                    if (dist[v] == -1) {
                        dist[v] = dist[u] + 1;
                        parent[v] = u;
                        q.offer(v);
                    } else if (parent[u] != v) {
                        ans = Math.min(ans, dist[u] + dist[v] + 1);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
}
}
