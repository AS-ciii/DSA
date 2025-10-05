class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
    
        int n = maze.length;
        ArrayList<String> paths = new ArrayList<>();

        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0)
            return paths;

        boolean[][] visited = new boolean[n][n];
        solve(0, 0, maze, n, visited, "", paths);

        Collections.sort(paths); // Sort in lexicographical order
        return paths;
    }

    private void solve(int i, int j, int[][] maze, int n, boolean[][] visited, String path, ArrayList<String> paths) {
        if (i == n - 1 && j == n - 1) {
            paths.add(path);
            return;
        }

        
        visited[i][j] = true;

  
        if (isSafe(i + 1, j, maze, n, visited))
            solve(i + 1, j, maze, n, visited, path + "D", paths);

       
        if (isSafe(i, j - 1, maze, n, visited))
            solve(i, j - 1, maze, n, visited, path + "L", paths);

     
        if (isSafe(i, j + 1, maze, n, visited))
            solve(i, j + 1, maze, n, visited, path + "R", paths);

   
        if (isSafe(i - 1, j, maze, n, visited))
            solve(i - 1, j, maze, n, visited, path + "U", paths);

      
        visited[i][j] = false;
    }
    
    
      private boolean isSafe(int i, int j, int[][] maze, int n, boolean[][] visited) {
        return (i >= 0 && j >= 0 && i < n && j < n && maze[i][j] == 1 && !visited[i][j]);
    }
}

