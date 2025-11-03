class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        // Code here
        
        Stack<Integer> st = new Stack<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> reverseAdj = new ArrayList<>();
        
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
            reverseAdj.add(new ArrayList<>());
        }
        
        int[] outdegree = new int[V];
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            reverseAdj.get(edge[1]).add(edge[0]);
            outdegree[edge[0]]++;
        }
        
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(outdegree[i]==0){
                q.offer(i);
            }
        }
        
        boolean[] safe = new boolean[V];
        while(!q.isEmpty()){
            int node = q.poll();
            safe[node]=true;
            for(int prev : reverseAdj.get(node)){
                outdegree[prev]--;
                if(outdegree[prev]==0)
                q.offer(prev);
            }
        }
        
        ArrayList<Integer> res= new ArrayList<>();
        for(int i=0;i<V;i++){
            if(safe[i]){
                res.add(i);
            }
        }
        
        Collections.sort(res);
        return res;
        
    }
    
}
