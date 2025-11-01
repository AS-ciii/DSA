class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        // code here
        int c[] = new int[n]; // In degree Array
        List<List<Integer>> edges = new ArrayList<>(); // adj array , store all the one direction edges
        ArrayList<Integer> ans = new ArrayList<>() ; // store the result
        Queue<Integer> q = new LinkedList<>(); // Queue for going thorugh node for BFS Approch 
        for(int i =0 ; i < n;i++) 
            edges.add(new ArrayList<>()); // Intialization
        for(int i[] : prerequisites){
            edges.get(i[1]).add(i[0]); // Storing the edges
            c[i[0]]++; // Increment the number if in Degree
        }
        for(int i =0 ; i < n ;i++)
            if(c[i]==0) 
                q.add(i); // If in degree is zero add it in the Queue
        while (!q.isEmpty()) {
            int e = q.poll(); // fetch top element form Queue
            ans.add(e); // Add that in the result as top element have indegree always zero
            for(int k : edges.get(e)) // go to all the edges connected to node 
                if(--c[k]==0) q.add(k); // if in degress for the element is zero add that in the queue
        }
        if(ans.size() != n) return new ArrayList<Integer>(); // check if the size of answer is total no of edges means no loop exist
        return ans;
    }
}
