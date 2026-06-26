class Solution {
    private static final int MOD = (int)1e9 + 7;
    
    public static int countWays(String s1, String s2) {
        
        int[][] memo = new int[s1.length() +1][s2.length() +1];
        for (int[] mem: memo) {
            Arrays.fill(mem, -1);
        }
        return solve(0, 0, s1, s2, memo);
    }
    
    private static int solve(int i, int j, String s, String t, int[][] memo) {
        if (j >= t.length()) {
            return 1;
        }
        
        if (memo[i][j] != -1) return memo[i][j];
        
        int cnt = 0;
        if (i < s.length()) {
            
            if (s.charAt(i) == t.charAt(j)) {
                cnt = (cnt + solve(i +1, j +1, s, t, memo)) % MOD;  // pick
            }
            cnt = (cnt + solve(i +1, j, s, t, memo)) % MOD; // skip
        }
        
        return memo[i][j] = cnt;
    }
}
