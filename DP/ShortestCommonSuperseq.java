class Solution {
    public static int minSuperSeq(String s1, String s2) {
        // code here
        int n = s1.length(); int m = s2.length();
        int[][] dp = new int[n+1][m+1];
      
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                dp[i][j] = Math.max(dp[i][j],Math.max(dp[i][j-1],dp[i-1][j]));
            }
        }
        return (n+m-dp[n][m]);
    }
}
