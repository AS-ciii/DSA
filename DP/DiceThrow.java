class Solution {
    static int noOfWays(int m, int n, int x) {
        // code here
        int dp[][] = new int[n+1][x+1];
        for(int i =0;i<=n;i++){
            Arrays.fill(dp[i], -1);
        }
        return ways(m, n, x, dp);
    }
    public static int ways(int m, int n, int x, int dp[][] ){
        if(x == 0 && n == 0){
            return 1;
        }
        if(x<=0 || n<=0)return 0;
        
        if(dp[n][x] != -1)return dp[n][x];
        int ans = 0;
        for(int i =1;i<=m;i++){
            ans += ways(m, n-1, x-i,dp);
        }
        return dp[n][x] = ans;
    }
};
