class Solution {
    public int minCutCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] allCuts = new int[c + 2];
        System.arraycopy(cuts, 0, allCuts, 1, c);
        allCuts[0] = 0;
        allCuts[c + 1] = n;
        Arrays.sort(allCuts);

        int[][] dp = new int[c + 2][c + 2];

        for (int len = 2; len <= c + 1; len++) {
            for (int i = 0; i + len <= c + 1; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                        dp[i][k] + dp[k][j] + allCuts[j] - allCuts[i]);
                }
            }
        }

        return dp[0][c + 1];
    }
}
