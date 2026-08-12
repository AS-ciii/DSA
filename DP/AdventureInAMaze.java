class Solution {
    public ArrayList<Integer> findWays(int[][] grid) {
        // Code here
        int n = grid.length;
        int mod = 1000000007;
        
        int[][] path = new int[n][n];
        int[][] maxAdventure = new int[n][n];
        
        path[0][0] = 1;
        maxAdventure[0][0] = grid[0][0];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int max1 = 0;
                int max2 = 0;
                
                if (i != 0 && (grid[i-1][j] == 2 || grid[i-1][j] == 3)) {
                    path[i][j] = (path[i][j] + path[i-1][j] % mod) % mod;
                    max1 = maxAdventure[i-1][j];
                }
                
                if (j != 0 && (grid[i][j-1] == 1 || grid[i][j-1] == 3)) {
                    path[i][j] = (path[i][j] + path[i][j-1] % mod) % mod;
                    max2 = maxAdventure[i][j-1];
                }
                
                if (max1 != 0 || max2 != 0) {
                    maxAdventure[i][j] = Math.max(max1, max2) + grid[i][j];
                }
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(path[n-1][n-1]);
        ans.add(maxAdventure[n-1][n-1]);
        
        return ans;
    }
}
