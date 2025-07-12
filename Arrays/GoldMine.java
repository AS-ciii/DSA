class Solution {
    public int maxGold(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        // Iterate through each column starting from the second last column
        for (int j = m - 2; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                int maxGold = mat[i][j + 1];
                
                // Check the cell diagonally up towards the right
                if (i > 0) {
                    maxGold = Math.max(maxGold, mat[i - 1][j + 1]);
                }
                
                // Check the cell diagonally down towards the right
                if (i < n - 1) {
                    maxGold = Math.max(maxGold, mat[i + 1][j + 1]);
                }
                
                // Update the current cell's value with the maximum gold that can be collected
                mat[i][j] += maxGold;
            }
        }
        
        // Find the maximum gold in the first column
        int maxGoldCollected = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxGoldCollected = Math.max(maxGoldCollected, mat[i][0]);
        }
        
        return maxGoldCollected;
    }
}

