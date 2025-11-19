class Solution {
    public int minCostPath(int[][] mat) {
        // code here
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,0});
        int ans = 0;
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        while(!pq.isEmpty()){
            int[] curr = pq.remove();
            int row = curr[0];
            int col = curr[1];
            int wt = curr[2];
            ans = Math.max(ans,wt);
            visited[row][col] = true;
            
            if(row==mat.length-1 && col==mat[0].length-1) break;
            
            for(int[] dir:directions){
                int newRow = row+dir[0];
                int newCol = col+dir[1];
                if(newRow>=0 && newRow<mat.length && 
                    newCol>=0 && newCol<mat[0].length && 
                     !visited[newRow][newCol]){
                    int diff = Math.abs(mat[newRow][newCol] - mat[row][col]);
                    pq.add(new int[]{newRow,newCol,diff});
                }
            }
        }
        
        return ans;
    }
}
