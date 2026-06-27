class Solution {
    public int countWays(int n, int m) {
		int[] dp = new int[n + 1];
		int md = 1000000007;
		for (int i = 1; i <= n; i++) {
			if (i<m)dp[i] = 1;
			else if (i == m)dp[i] = 2;
			else dp[i] = (dp[i - 1]+dp[i - m])%md;
		}
		return dp[n];
}
}
