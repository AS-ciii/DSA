class Solution {
    
    Integer[][] dp;
    
    public int solve(int digitCnt , int sum , int n){
        if(digitCnt == n){
            return sum == 0 ? 1 : 0;
        }
        
        if(dp[digitCnt][sum] != null){
            return dp[digitCnt][sum];
        }
        int i = 1;
        if(digitCnt > 0){
            i = 0;
        }
        int cnt = 0;
        while(i <= 9){
            if(i <= sum){
                cnt += solve(digitCnt + 1 , sum - i , n);
            }
            i++;
        }
        return dp[digitCnt][sum] = cnt;
    }
    public int countWays(int n, int sum) {
        // code here
        dp = new Integer[n + 1][sum + 1];
        
        int ans = solve(0 , sum , n);
        return ans == 0 ? -1 : ans;
    }
};
