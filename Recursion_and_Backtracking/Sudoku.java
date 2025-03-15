package Recursion_and_Backtracking;

class Solution {
    // Function to find a solved Sudoku.
    static void solveSudoku(int[][] mat) {
        solve(mat);
    }
    
    private static boolean solve(int[][] matrix) {
        for(int row=0; row<9; row++) {
            for(int col=0; col<9; col++) {
                if(matrix[row][col]==0) {
                    for(int num=1; num<=9; num++) {
                        if(isValid(matrix, row, col, num)) {
                            matrix[row][col] = num;
                            
                            if(solve(matrix)) return true;
                            
                            matrix[row][col] = 0;
                        }
                    }
                    
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private static boolean isValid(int[][] mat, int row, int col, int num) {
        for(int i=0; i<9; i++) {
            if(mat[row][i]==num || mat[i][col]==num) return false;
        }
        
        int rowStart = (row/3)*3;
        int colStart = (col/3)*3;
        
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(mat[rowStart+i][colStart+j]==num) return false;
            }
        }
        
        return true;
    }
    
    
}
