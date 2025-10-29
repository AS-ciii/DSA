class Solution {
    public int[] bfs(ArrayList<ArrayList<Integer>> adj,int V,int st)
    {
        boolean vis[]=new boolean[V+1];
        Queue<Integer> q=new LinkedList<>();
        int fardestNode=0;
        int dis=0;
        q.add(st);
        vis[st]=true;
        while(!q.isEmpty())
        {
            int n=q.size();
            dis++;
            for(int i=0;i<n;i++)
            {
                int temp=q.poll();
                fardestNode=temp;
                for(int nei:adj.get(temp))
                {
                    if(!vis[nei])
                    {
                        q.add(nei);
                        vis[nei]=true;
                    }
                }
                
            }
        }
        int arr[]={fardestNode,dis-1};
        return arr;
    }
    public int diameter(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        int a[]=bfs(adj,V,0);
        int b[]=bfs(adj,V,a[0]);
        
        //System.out.println(a[0]+" "+a[1]);
        
        return b[1];
    }
}
