class Solution {
 int[][] dp;

    public int maxDotProduct(int[] a, int[] b) {

        int n = a.length;
        int m = b.length;

        dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(a, b, 0, 0);
    }

    private int solve(int[] a, int[] b, int i, int j) {

        int n = a.length;
        int m = b.length;

        // All elements of b have been matched
        if (j == m) {
            return 0;
        }

        // No elements left in a
        if (i == n) {
            return Integer.MIN_VALUE;
        }

        // Not enough elements left in a
        if (n - i < m - j) {
            return Integer.MIN_VALUE;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Skip current element of a
        int skip = solve(a, b, i + 1, j);

        // Match current elements
        int match = a[i] * b[j];
        int next = solve(a, b, i + 1, j + 1);

        if (next != Integer.MIN_VALUE) {
            match += next;
        }

        return dp[i][j] = Math.max(skip, match);
    }
}
