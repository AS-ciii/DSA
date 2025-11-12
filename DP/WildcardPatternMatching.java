class Solution {
    public boolean wildCard(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();
        
        boolean [][]dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for(int i = 1; i <= m; i++) {
            if(pat.charAt(i - 1) != '*') break;
            dp[0][i] = dp[0][i - 1];
        }
        
        for(int i = 1; i <= n; i++) {
            char s = txt.charAt(i - 1);
            for(int j = 1; j <= m; j++) {
                char t = pat.charAt(j - 1);
                
                if(s == t || t == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if(t == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        
        return dp[n][m];
    }
}
