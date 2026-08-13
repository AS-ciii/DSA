class Solution {
    public int[] maxDistance(int V, int src, ArrayList<ArrayList<Integer>> edges) {
        // code here
         
          
          int dis[]=new int[V];
          Arrays.fill(dis,Integer.MIN_VALUE);
          
          dis[src]=0;
          for(int i=0;i<V;i++){
          for(ArrayList<Integer>edge:edges){
              int u=edge.get(0);
              int v=edge.get(1);
              int w=edge.get(2);
              
              if(dis[v]<dis[u]+w && dis[u]!=Integer.MIN_VALUE){
                  dis[v]=dis[u]+w;
              }
              
          }
          }
          
          
          
          return dis;
          
    }
}
