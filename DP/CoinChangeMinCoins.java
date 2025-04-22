package DP;

class Solution {

    public int minCoins(int coins[], int sum) {
        int n = coins.length;;
        int dp[] = new int[sum+1];
        
        Arrays.fill(dp, sum+1);
        dp[0] = 0;
        
        for(int i=1; i<=sum; i++) {
            for(int coin : coins) {
                if(i>=coin) dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        
        return dp[sum] == sum+1?-1:dp[sum];
    }
}
