class Solution {
    public boolean isWordExist(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    if (dfs(mat, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] mat, String word, int r, int c, int index) {
        if (index == word.length() - 1) {
            return true;
        }
        
        char temp = mat[r][c];
        mat[r][c] = '#';
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        for (int k = 0; k < 4; k++) {
            int newR = r + dr[k];
            int newC = c + dc[k];
            
            if (newR >= 0 && newR < mat.length && 
                newC >= 0 && newC < mat[0].length && 
                mat[newR][newC] == word.charAt(index + 1)) {
                
                if (dfs(mat, word, newR, newC, index + 1)) {
                    return true;
                }
            }
        }
        
        // Backtrack: Unmark the current cell so other paths can use it
        mat[r][c] = temp;
        
        return false;
    }
}
