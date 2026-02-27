class Solution {
    public int countSquare(int[][] mat, int x) {
        // code here
        int row = mat.length;
        int col = mat[0].length;
        
        int[][] pSum = new int[row+1][col+1];
        
        //calculating prefixsum
        for(int i = 1 ; i < row + 1 ; i++){
            for(int j = 1 ; j < col + 1 ; j++){
                pSum[i][j] = pSum[i-1][j] + pSum[i][j-1] - pSum[i-1][j-1] + mat[i-1][j-1];
            }
        }
        
        int sqSubMatrices = 0;
        
        for(int side = 1 ; side <= Math.min(row , col) ; side++){
            for(int i = 1 ; i < row + 1 ; i++){
                for(int j = 1 ; j < col + 1 ; j++){
                    
                    if((i - side >= 0) && (j - side >= 0)){
                        int corner_i = i - side;
                        int corner_j = j - side;
                        
                        int sum = pSum[i][j] - pSum[corner_i][j] - pSum[i][corner_j] + pSum[corner_i][corner_j];
                        if(sum == x){
                            sqSubMatrices++;
                        }
                    }
                }
            }
        }
        
        return sqSubMatrices;
    }
}
