class Solution {
    public int orangesRotting(int[][] mat) {
        if(mat==null || mat.length == 0) return -1;
        
        int n = mat.length, m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int frOrange = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(mat[i][j]==2) q.add(new int[]{i, j});
                else if(mat[i][j] == 1) frOrange++;
            }
        }
        
        if(frOrange == 0) return 0;
        
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int min = 0;
        
        while(!q.isEmpty()) {
            int s = q.size();
            boolean rotted = false;
            for(int i=0; i<s; i++) {
                int[] rotten = q.poll();
                int x = rotten[0];
                int y = rotten[1];
                
                for(int[] d : dir) {
                    int nx = x+d[0];
                    int ny = y+d[1];
                    
                    if(nx>=0 && ny>=0 && nx<n && ny<m && mat[nx][ny]==1) {
                        mat[nx][ny] = 2;
                        q.add(new int[]{nx, ny});
                        frOrange--;
                        rotted = true;
                    }
                }
            }
            if(rotted) min++;
        }
        
        return (frOrange==0)?min : -1;
        
        
    }
}
