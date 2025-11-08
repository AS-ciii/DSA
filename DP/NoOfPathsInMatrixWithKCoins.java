class Solution {
    public int numberOfPath(int[][] mat, int k) {
        // code here
        int n= mat.length;
        int m= mat[0].length;
        int dp[][][]= new int[n][m][k+1];
        for (int[][] arr2D : dp) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }
        return intPaths(mat,k,0,0,mat[0][0],n,m,dp);
    }
    public int intPaths(int[][] mat, int k, int i, int j, int coin, int n, int m, int[][][] dp){
        if (coin > k) return 0;
        if(i==n-1 && j==m-1){
            if(coin==k) return 1;
            else return 0;
        }
        if(dp[i][j][coin] != -1) return dp[i][j][coin];
        int right=0;
        int down=0;
        if(i+1<n) right=intPaths(mat,k,i+1,j,coin+mat[i+1][j],n,m,dp);
        if(j+1<m) down=intPaths(mat,k,i,j+1,coin+mat[i][j+1],n,m,dp);
        return dp[i][j][coin]= right+down;
    }
}
