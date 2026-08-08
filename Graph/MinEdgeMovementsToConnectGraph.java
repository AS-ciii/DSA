class Solution {
    int minEdgesReq(int n, int[][] edges) {
        
           if (edges.length < n - 1) {
        return -1;
    }
    List<List<Integer>> adjList = new ArrayList<>();

for (int i = 0; i < n; i++) {
    adjList.add(new ArrayList<>());
}
for(int i=0;i<edges.length;i++)
{
    int u=edges[i][0];
    int v=edges[i][1];
    adjList.get(u).add(v);
    adjList.get(v).add(u);
}
int components = 0;
boolean[] visited = new boolean[n];
for (int i = 0; i < n; i++) {

    if (!visited[i]) {
        components++;
        dfs(i, adjList, visited);
    }
    
    }
    
        return components-1;

    }
     void dfs(int node,  List<List<Integer>> adjList,boolean[]visited)
    {
       visited[node]=true;
       for(int i:adjList.get(node))
       {
           if(!visited[i])
           {
               dfs(i,adjList,visited);
           }
       }
    }
}

