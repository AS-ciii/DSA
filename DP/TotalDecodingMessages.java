package DP;

class Solution {
    public int countWays(String digits) {
        if(digits==null || digits.length()==0 || digits.charAt(0)=='0') return 0;
        
        
        int n = digits.length();
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        
        for(int i=2; i<=n; i++) {
            int one = digits.charAt(i-1)-'0';
            int two = Integer.parseInt(digits.substring(i-2, i));
            
            if(one >= 1) dp[i] += dp[i-1];
            if(two >= 10 && two <= 26) dp[i] += dp[i-2];
        }
        return dp[n];
    }
}