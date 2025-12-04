class Solution {
    public int minCost(int[] keys, int[] freq) {
        int n = keys.length;
        int[][] dp = new int[n][n];
        int[][] opt = new int[n][n];
        int[] pre = new int[n + 1];

        for (int i = 0; i < n; i++) pre[i + 1] = pre[i] + freq[i];
        for (int i = 0; i < n; i++) {
            dp[i][i] = freq[i];
            opt[i][i] = i;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                int L = opt[i][j - 1];
                int R = opt[i + 1][j];

                for (int k = L; k <= R; k++) {
                    int left = k > i ? dp[i][k - 1] : 0;
                    int right = k < j ? dp[k + 1][j] : 0;
                    int cost = left + right + (pre[j + 1] - pre[i]);
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        opt[i][j] = k;
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
