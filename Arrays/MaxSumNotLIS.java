class Solution {
    public int nonLisMaxSum(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];        // Length of LIS ending at i
        int[] dps = new int[n];       // Sum of LIS ending at i

        Arrays.fill(dp, 1);           // Each element is an LIS of length 1
        for (int i = 0; i < n; i++) {
            dps[i] = arr[i];          // Initial LIS sum is the element itself
        }

        // DP to calculate LIS and corresponding minimum sum
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        dps[i] = dps[j] + arr[i];
                    } else if (dp[i] == dp[j] + 1) {
                        dps[i] = Math.min(dps[i], dps[j] + arr[i]);
                    }
                }
            }
        }

        int maxLen = 0;
        int totalSum = 0;
        int minLisSum = Integer.MAX_VALUE;

        // Find total sum and maximum LIS length
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            maxLen = Math.max(maxLen, dp[i]);
        }

        // From all LIS of max length, get the one with minimum sum
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLen) {
                minLisSum = Math.min(minLisSum, dps[i]);
            }
        }

        return totalSum - minLisSum;
    }

  
}

