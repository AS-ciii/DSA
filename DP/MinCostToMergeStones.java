class Solution {
    public static int mergeStones(int[] stones, int k) {
        int n = stones.length;
        // Feasibility check:
        if ((n - 1) % (k - 1) != 0) return -1;

        // prefix sums
        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) pref[i + 1] = pref[i] + stones[i];

        // dp[i][j] = min cost to merge stones[i..j] into the minimal possible number of piles
        long[][] dp = new long[n][n];
        final long INF = Long.MAX_VALUE / 4;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) dp[i][j] = 0L;
        }

        // len = interval length
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = INF;
                // try splits; we only need to consider splits m where left and right can be reduced properly
                // stepping by (k-1) enforces the number-of-piles compatibility
                for (int m = i; m < j; m += (k - 1)) {
                    long left = dp[i][m];
                    long right = dp[m + 1][j];
                    if (left == INF || right == INF) continue;
                    dp[i][j] = Math.min(dp[i][j], left + right);
                }
                // If this interval can be merged into 1 pile, add the interval sum
                if ((j - i) % (k - 1) == 0) {
                    dp[i][j] = dp[i][j] == INF ? INF : dp[i][j] + (pref[j + 1] - pref[i]);
                }
            }
        }

        long ans = dp[0][n - 1];
        return ans >= INF ? -1 : (int) ans;
    }

    // quick main for local testing (optional)
    public static void main(String[] args) {
        System.out.println(mergeStones(new int[]{1, 2, 3}, 2)); // 9
        System.out.println(mergeStones(new int[]{3,2,4,1}, 2)); // example more
    }
}
