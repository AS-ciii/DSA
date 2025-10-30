class Solution {
    public void fill(char[][] grid) {
        // Code here
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]=='O'){
                checkZero(grid, i, 0);
            }
        }
        for(int i=0;i<grid.length;i++){
            if(grid[i][grid[0].length-1]=='O'){
                checkZero(grid, i, grid[0].length-1);
            }
        }
        for(int i=0;i<grid[0].length;i++){
            if(grid[0][i]=='O'){
                checkZero(grid, 0, i);
            }
        }
        for(int i=0;i<grid[0].length;i++){
            if(grid[grid.length-1][i]=='O'){
                checkZero(grid, grid.length-1, i);
            }
        }
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='O'){
                    grid[i][j] = 'X';
                }
            }
        }
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='0'){
                    grid[i][j] = 'O';
                }
            }
        }
    }
    
    void checkZero(char[][] grid, int i, int j){
        if(grid[i][j]=='O'){
            grid[i][j] = '0';
        }
        
        if(j-1>=0 && grid[i][j-1]=='O'){
            checkZero(grid, i, j-1);
        }
        if(i-1>=0 && grid[i-1][j]=='O'){
            checkZero(grid, i-1, j);
        }
        if(i+1<grid.length && grid[i+1][j]=='O'){
            checkZero(grid, i+1, j);
        }
        if(j+1<grid[i].length && grid[i][j+1]=='O'){
            checkZero(grid, i, j+1);
        }
        
    }
}
