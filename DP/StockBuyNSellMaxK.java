package DP;

class Solution {
    static int maxProfit(int prices[], int k) {
        int n = prices.length;
        if(n==0 || k==0) return 0;
        
        if(k>=n/2) {
            int mp = 0;
            for(int i=1; i<n; i++) {
                if(prices[i] > prices[i-1]) mp += prices[i]-prices[i-1];
            }
            
            return mp;
        }
        
        int dp[][] = new int[k+1][n];
        
        for(int i=1; i<=k; i++) {
            int md = -prices[0];
            
            for(int j=1; j<n; j++) {
                dp[i][j] = Math.max(dp[i][j-1], prices[j]+md);
                md = Math.max(md, dp[i-1][j]-prices[j]);
            }
        }
        
        return dp[k][n-1];
    }
}
