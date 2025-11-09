class Solution {
    public int toDest(int[][] mat, int i1, int j1, int i2, int[][][] dp){
        
        // j2 is calculated because total steps taken are same → i1+j1 = i2+j2
        int j2 = i1 + j1 - i2;
        
        // If any pointer goes out of grid → invalid path
        if(i1>=mat.length || j1>=mat[0].length || i2>=mat.length || j2>=mat[0].length){
            return Integer.MIN_VALUE/2;
        }
        
        // If any cell is blocked → invalid
        if(mat[i1][j1]==-1 || mat[i2][j2]==-1) return Integer.MIN_VALUE/2; // blocked
        
        // If first pointer reached destination → this is the final step
        if(i1==mat.length-1 && j1==mat[0].length-1){
            return mat[i1][j1]; // destination cell chocolate counted once
        }
        
        if(dp[i1][j1][i2]!=-2){ // if already evaluated
            return dp[i1][j1][i2]; // directly return it 
        }
        
        
        int currChoc = mat[i1][j1]; // Chocolates collected from positions of both pointers
        if(i1!=i2 || j1!=j2){
            // If both pointers are not at same cell → add second cell chocolate too
            currChoc += mat[i2][j2];
        }
        
        int best = Integer.MIN_VALUE;
        
        // Move combinations:
        // Person 1: Down, Person 2: Down
        int option1 = toDest(mat, i1+1, j1, i2+1, dp);
        best = Math.max(best, option1);
    
        // Person 1: Down, Person 2: Right
        int option2 = toDest(mat, i1+1, j1, i2, dp);
        best = Math.max(best, option2);
    
        // Person 1: Right, Person 2: Down
        int option3 = toDest(mat, i1, j1+1, i2+1, dp);
        best = Math.max(best, option3);
    
        // Person 1: Right, Person 2: Right
        int option4 = toDest(mat, i1, j1+1, i2, dp);
        best = Math.max(best, option4);
        
        // Store result = chocolates collected here + best future result
        return dp[i1][j1][i2] = currChoc + best;
    }
    public int chocolatePickup(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        
        int[][][] dp = new int[n][m][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                Arrays.fill(dp[i][j], -2);
            }
        }
        
        // Start both persons from (0,0)
        int ans = toDest(mat, 0, 0, 0, dp);
        
        return Math.max(ans, 0);
    }
}
