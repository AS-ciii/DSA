public class Solution {
    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int x, int y) {
            int xr = find(x), yr = find(y);
            if (xr == yr) return false;
            if (rank[xr] < rank[yr]) parent[xr] = yr;
            else if (rank[xr] > rank[yr]) parent[yr] = xr;
            else {
                parent[yr] = xr;
                rank[xr]++;
            }
            return true;
        }
    }

    static class Edge implements Comparable<Edge> {
        int u, v, w, idx;
        Edge(int u, int v, int w, int idx) { this.u = u; this.v = v; this.w = w; this.idx = idx; }
        @Override
        public int compareTo(Edge other) { return Integer.compare(this.w, other.w); }
    }

    public int secondMST(int V, int[][] edges) {
        int m = edges.length;
        Edge[] edgeList = new Edge[m];
        for (int i = 0; i < m; i++) {
            edgeList[i] = new Edge(edges[i][0], edges[i][1], edges[i][2], i);
        }
        Arrays.sort(edgeList);

        DSU dsu = new DSU(V);
        long mstWeight = 0;
        List<Edge> mstEdges = new ArrayList<>();
        boolean[] inMst = new boolean[m];

        // Build MST using Kruskal
        for (Edge e : edgeList) {
            if (dsu.union(e.u, e.v)) {
                mstWeight += e.w;
                mstEdges.add(e);
                inMst[e.idx] = true;
            }
        }

        if (mstEdges.size() != V - 1) return -1; // no MST (graph disconnected)

        long second = Long.MAX_VALUE;

        // Try removing each MST edge and find minimal replacement edge to reconnect
        for (int removeIdx = 0; removeIdx < mstEdges.size(); removeIdx++) {
            DSU dsu2 = new DSU(V);
            long weight = 0;
            // add all MST edges except the removed one
            for (int j = 0; j < mstEdges.size(); j++) {
                if (j == removeIdx) continue;
                Edge e = mstEdges.get(j);
                dsu2.union(e.u, e.v);
                weight += e.w;
            }

            // scan sorted edges to find smallest non-MST edge that connects remaining components
            for (Edge e : edgeList) {
                if (!inMst[e.idx] && dsu2.find(e.u) != dsu2.find(e.v)) {
                    long candidate = weight + e.w;
                    if (candidate > mstWeight) second = Math.min(second, candidate);
                    break; // because edges are sorted, first that connects is minimal for this removal
                }
            }
        }

        return (second == Long.MAX_VALUE) ? -1 : (int) second;
    }
}
