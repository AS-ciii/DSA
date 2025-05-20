class Solution {
    
    
    // finding the total nodes in the given binary tree.
    public static int maximum(Node root){
        if(root == null){
            return 0;
        }
        
        
        int leftM = maximum(root.left);
        int rightM = maximum(root.right);
        
        return Math.max(root.data, Math.max(leftM, rightM));
    }
    
    // doing the Preorder traversal to find the neighbours of each node and storing it in the list.
    public static void preorder(Node root, ArrayList<ArrayList<Integer>> list){
        if(root == null){
            return;
        }
        
        // adding the left children of current node in the list.
        if(root.left != null){
            list.get(root.data).add(root.left.data);
            list.get(root.left.data).add(root.data);// adding the edge in both the direction.
        }
       
       // adding the left children of current node in the list. 
        if(root.right != null){
            list.get(root.data).add(root.right.data);
            list.get(root.right.data).add(root.data); // adding in both the direction.
        }
        
        preorder(root.left, list);
        preorder(root.right, list);
    }
    
    
    public static int minTime(Node root, int target) {
        if(root == null){
            return 0;
        }
        // total nodes
        int maxi = maximum(root);
        
        // making a List of List to store node values.
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        // initialise the list.
        
        for(int i = 0; i < maxi+1; i++){
            list.add(new ArrayList<>());
        }
        
        // Going to each node and storing their children in the list of list.
        preorder(root, list);
        
        // System.out.println(list);
        
        // visited array to track the vis & non vis nodes.
        boolean vis[] = new boolean[maxi+1];
        
        
        int totalTime = 0;
        
        // Using the BFS to traverse on the given tree and then finding the total time to burn all the nodes.
        Queue<Integer> q = new LinkedList<>();
        
        // adding the target in the queue to start the BFS or as the source
        q.add(target);
        // make it visit as fire starts from here.
        vis[target] = true;
        
        // Going to each node and finding the neighbours of each node and making them visited and 
        // setting the fire and increasing the total time.
        
        
        // Note: If any of the neighbour of the current node is not burnt, then just burn it and
        // and increase the total time. But if all the nbrs are already burnt, then dont increase the time.
        
        // Here burn the node means: Make the correspoinding vis array as true.
        while(!q.isEmpty()){
            int size = q.size();
            boolean burnedNode = false;
            for(int i = 0; i < size; i++){
                int curr = q.poll();
                // traversing on the nbrs of current node.
                for(int j = 0; j < list.get(curr).size(); j++){
                    int idx = list.get(curr).get(j);
                    // if any nbr is not visited, then visit it and push it in the queue.
                    if(!vis[idx]){
                        q.add(list.get(curr).get(j));
                        burnedNode = true;
                        vis[idx] = true;
                    }
                }
            }
            if(burnedNode){
                totalTime++;
            }
        }
        // returning the total time required to burn all the nodes.
        return totalTime;
    }
}
