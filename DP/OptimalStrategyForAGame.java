class Solution {
    public int maximumAmount(int arr[]) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int gap = 0; gap < n; gap++){
            for(int i = 0 ; i+gap < n; i++){
                int j = i+ gap;
                int x = (i + 2 <= j) ? dp[i+ 2][j] : 0;
                int y = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0;
                int z = (i <= j - 2) ? dp[i][j - 2] : 0;
            
                dp[i][j] = Math.max(
                    arr[i] + Math.min(x, y),   // pick i
                    arr[j] + Math.min(y, z)    // pick j
                );
            }
            
        }
        return dp[0][n - 1];
        
    }
}
