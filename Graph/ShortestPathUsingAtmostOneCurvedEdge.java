class Solution {
    private static final long INF = Long.MAX_VALUE / 4;
        
    static class Edge {
        int to;
        int w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }
        
    static class Node implements Comparable<Node> {
        int v;
        int usedCurved;
        long dist;
        Node(int v, int usedCurved, long dist) { this.v = v; this.usedCurved = usedCurved; this.dist = dist; }
        public int compareTo(Node o) { return Long.compare(this.dist, o.dist); }
    }
        
    public int shortestPath(int V, int a, int b, int[][] edges) {
        List<List<Edge>> straight = new ArrayList<>(V);
        List<List<Edge>> curved = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            straight.add(new ArrayList<>());
            curved.add(new ArrayList<>());
        }
            
        for (int[] e : edges) {
            int x = e[0], y = e[1], w1 = e[2], w2 = e[3];
            straight.get(x).add(new Edge(y, w1));
            straight.get(y).add(new Edge(x, w1));
            curved.get(x).add(new Edge(y, w2));
            curved.get(y).add(new Edge(x, w2));
        }
            
        long[][] dist = new long[V][2];
        for (int i = 0; i < V; i++) {
            dist[i][0] = dist[i][1] = INF;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[a][0] = 0;
        pq.add(new Node(a, 0, 0));
            
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.dist != dist[cur.v][cur.usedCurved]) continue;
            int v = cur.v;
            int used = cur.usedCurved;
            long d = cur.dist;
                
            for (Edge ed : straight.get(v)) {
                int to = ed.to;
                long nd = d + ed.w;
                if (nd < dist[to][used]) {
                    dist[to][used] = nd;
                    pq.add(new Node(to, used, nd));
                }
            }
             
            if (used == 0) {
                for (Edge ed : curved.get(v)) {
                    int to = ed.to;
                    long nd = d + ed.w;
                    if (nd < dist[to][1]) {
                        dist[to][1] = nd;
                        pq.add(new Node(to, 1, nd));
                    }
                }
            }
        }
            
        long ans = Math.min(dist[b][0], dist[b][1]);
        return (ans >= INF) ? -1 : (int) ans;
    }
}
