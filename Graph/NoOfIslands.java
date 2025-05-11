class Solution {
    public int countIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] visited = new boolean[n][m];
        int islandCount = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 'L' && !visited[i][j]) {
                    dfs(grid, visited, i, j, n, m);
                    islandCount++;
                }
            }
        }
        
        return islandCount;
    }
    
    private int[] dRow = {-1, -1, -1, 0, 0, 1, 1, 1};
    private int[] dCol = {-1, 0, 1, -1, 1, -1, 0, 1};
    private void dfs(char[][] grid, boolean[][] visited, int row, int col, int n, int m) {
        visited[row][col] = true;
        for(int k=0; k<8; k++) {
            int nr = row + dRow[k];
            int nc = col + dCol[k];
            if(isValid(grid, visited, nr, nc, n, m)) {
                dfs(grid, visited, nr, nc, n, m);
            }
        }
    }
    
    private boolean isValid(char[][] grid, boolean[][] visited, int r, int c, int n, int m) {
        return (r>=0 && r<n && c>=0 && c<m && grid[r][c] == 'L' && !visited[r][c]);
    }
}
