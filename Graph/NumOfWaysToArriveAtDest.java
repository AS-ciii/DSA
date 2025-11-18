class Solution {
    class Edge{
        int src , dst , time;
        Edge(int src , int dst , int time){
            this.src = src;
            this.dst = dst;
            this.time = time;
        }
    }
    class Pair implements Comparable<Pair>{
        int node ;
        int time;
        Pair(int node , int time){
            this.node = node;
            this.time = time;
        }
        public int compareTo(Pair p2){
            return this.time - p2.time;
        }
    }
    public int countPaths(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int t = edge[2];
            graph.get(u).add(new Edge(u , v , t));
            graph.get(v).add(new Edge(v , u , t));
        }
        int[] distance = new int[V];
        Arrays.fill(distance , Integer.MAX_VALUE);
        distance[0] = 0;
        boolean[] visited = new boolean[V];
        int[] ways = new int[V];
        ways[0] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0 , 0));
       
        
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            
            if(!visited[curr.node]){
                visited[curr.node] = true;
                
                for(int i = 0 ; i < graph.get(curr.node).size() ; i++){
                    Edge edge = graph.get(curr.node).get(i);
                    int u = edge.src;
                    int v = edge.dst;
                    int time = edge.time;
                    if(distance[u] + time < distance[v]){
                        distance[v] = distance[u] + time;
                        pq.add(new Pair(v , distance[v]));
                        ways[v] = ways[u];
                    }else if((distance[u] + time) == distance[v]){
                        ways[v] = ways[v] + ways[u];
                    }
                }
            }
        }
        return ways[V - 1];
        
    }
}
