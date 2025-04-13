package DP;

class Solution {
    public boolean wordBreak(String s, String[] dictionary) {
        Set<String> dict = new TreeSet<>(Arrays.asList(dictionary));
        
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(String word : dictionary) {
            min = Math.min(min, word.length());
            max = Math.max(max, word.length());
        }
        
        
        for(int i=min; i<=n; i++) {
            for(int j=Math.max(0, i-max); j<=i-min; j++) {
                if(dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[n];
        
    }
}
