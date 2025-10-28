class Solution {
    // Node class to store current cell coordinates and distance (steps)
    class Node{
        int i;
        int j;
        int steps;
        Node(int i, int j, int steps){
            this.i = i;
            this.j = j;
            this.steps = steps;
        }
    }
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Node> q = new LinkedList<>(); // BFS queue
        boolean[][] isVisited = new boolean[n][m]; 
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(); // final answer matrix
        
        for(int i=0; i<n; i++){
            // Initialize result with -1 and push all '1' cells into the queue
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0; j<m; j++){
                temp.add(-1); // initially mark all cells as unprocessed (-1)
                
                // if current cell has value 1 → source cell for BFS
                if(grid[i][j]==1){
                    q.add(new Node(i, j, 0)); // enqueue with distance 0
                    isVisited[i][j] = true; // mark as visited
                }
            }
            result.add(temp); // add row to result
        }
        
        // up, right, down, left
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        while(!q.isEmpty()){
            Node curr = q.poll(); // get current cell
            int row = curr.i;
            int col = curr.j;
            int steps = curr.steps;
            
            result.get(row).set(col, steps); // update distance in result
            
            // explore 4 neighboring cells
            for(int i=0; i<4; i++){
                int nrow = row + dir[i][0];
                int ncol = col + dir[i][1];
                
                // check bounds and visit only unvisited cells
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !isVisited[nrow][ncol]){
                    isVisited[nrow][ncol] = true; // mark neighbor visited
                    q.add(new Node(nrow, ncol, steps+1)); // push neighbor with +1 distance
                }
            }
        }
        return result; // Return the filled distance matrix
    }
}
