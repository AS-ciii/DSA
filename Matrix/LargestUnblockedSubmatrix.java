class Solution {
    public int largestArea(int n, int m, int[][] arr) {
        // code here
        int k=arr.length;
        int a[][]=new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(a[i],1);
            
        for(int i=0;i<k;i++){
            int r=arr[i][0]-1;
            int c=arr[i][1]-1;
            for(int x=0;x<n;x++)
                a[x][c]=-1;
            for(int y=0;y<m;y++)
                a[r][y]=-1;
        }
        
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]==1){
                   res=Math.max(res, dfs(i,j,n,m,a));
                }
            }
        }
        
        return res;
    }
    int dfs(int i,int j,int n,int m,int a[][]){
        if(i<0 || i>=n ||j<0 || j>=m || a[i][j]!=1)
            return 0;
        a[i][j]=2;
        int right=dfs(i,j+1,n,m,a);
        int down=dfs(i+1,j,n,m,a);
        return 1+right+down;
    }
}
