class Solution {
    public int totalWays(int[] arr, int target) {
        int total = 0;
        for (int num : arr) 
            total += num;

        // Feasibility check
        if ((total + target) % 2 != 0 || total < Math.abs(target)) 
            return 0;

        int sumPos = (total + target) / 2;

        // DP array
        int[] dp = new int[sumPos + 1];
        dp[0] = 1;

        for (int num : arr) {
            for (int j = sumPos; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[sumPos];
    }
}
