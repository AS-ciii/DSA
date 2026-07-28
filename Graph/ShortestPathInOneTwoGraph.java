class Solution {
    class Pair {
        int node;
        int cost;
        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    public int shortestPath(int V, int src, int dest, int[][] edges) {
    // code here
        int n = edges.length;
        ArrayList<ArrayList<Pair>> list = new ArrayList<>();
        
        for (int i = 0; i<V; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int e[]:edges) {
            int u = e[0];
            int v = e[1];
            int c = e[2];
            list.get(u).add(new Pair(v, c));
            list.get(v).add(new Pair(u, c));
         
        }
        PriorityQueue<Pair>pq = new PriorityQueue<>((a, b)-> {
            return a.cost - b.cost;
        });
         
        pq.offer(new Pair(src, 0));
        int dist[] = new int[V];
         
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;
         
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int ele = p.node;
            int cost = p.cost;
             
            if (dist[ele]<cost)continue;
             
            for (Pair a:list.get(ele)) {
                int e = a.node;
                int d = a.cost;
                int total = cost + d;
                
                if (total<dist[e]){
                    dist[e]=total;
                    pq.offer(new Pair(e,total));
                }
     
            }
        }
        
        if(dist[dest]==Integer.MAX_VALUE) return -1;
        
        return dist[dest];
    }
}
