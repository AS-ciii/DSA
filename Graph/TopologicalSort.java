class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++) adj.add(new ArrayList<>());
        
        for(int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
        }
        
        int[] id = new int[V];
        for(int u=0; u<V; u++) {
            for(int v : adj.get(u)) id[v]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++) {
            if(id[i]==0) q.offer(i);
        }
        
        ArrayList<Integer> to = new ArrayList<>();
        while(!q.isEmpty()) {
            int u = q.poll();
            to.add(u);
            
            for(int v : adj.get(u)) {
                id[v]--;
                if(id[v]==0) q.offer(v);
            }
        }
        
        return to;
    }
}
