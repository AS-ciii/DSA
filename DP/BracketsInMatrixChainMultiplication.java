class Solution {
    String build(int i, int j, int[][] br) {
        if (i == j) return String.valueOf((char)('A' + i - 1));
        int k = br[i][j];
        return "(" + build(i, k, br) + build(k + 1, j, br) + ")";
    }

    public String matrixChainOrder(int arr[]) {
        int n = arr.length;
        int m = n - 1;

        long[][] dp = new long[m + 2][m + 2];
        int[][] br = new int[m + 2][m + 2];

        for (int len = 2; len <= m; len++) {
            for (int i = 1; i + len - 1 <= m; i++) {
                int j = i + len - 1;
                dp[i][j] = Long.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    long cost = dp[i][k] + dp[k + 1][j] + (long) arr[i - 1] * arr[k] * arr[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        br[i][j] = k;
                    }
                }
            }
        }

        return build(1, m, br);
    }
}
