class Solution {
    public int validGroups(String s) {
        int n = s.length();
        // dp[i][prev] = number of ways starting at index i with previous sum = prev
        // prev can go up to 900 (since max sum of 100 digits '9' = 900)
        Integer[][] dp = new Integer[n+1][901];
        return dfs(s, 0, 0, dp);
    }
    
    private int dfs(String s, int idx, int prevSum, Integer[][] dp) {
        if (idx == s.length()) return 1; // reached end, valid grouping
        
        if (dp[idx][prevSum] != null) return dp[idx][prevSum];
        
        int ways = 0;
        int sum = 0;
        
        // try all possible substrings starting at idx
        for (int j = idx; j < s.length(); j++) {
            sum += s.charAt(j) - '0';
            if (sum >= prevSum) {
                ways += dfs(s, j+1, sum, dp);
            }
        }
        
        return dp[idx][prevSum] = ways;
    }
}
