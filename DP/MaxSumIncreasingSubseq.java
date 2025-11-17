class Solution {
    public int maxSumIS(int arr[]) {
        // code here
        int n = arr.length;
        if (n == 0) return 0;

 
        // dp[i] = max sum of an increasing subsequence ending at i (must include arr[i])
        int[] dp = new int[n];
        int maxSum = 0;

 
        // initialize dp with the element itself (subsequence of length 1)
        for (int i = 0; i < n; i++) dp[i] = arr[i];

 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    int candidate = dp[j] + arr[i];
                    if (candidate > dp[i]) dp[i] = candidate;
                }
            }
            if (dp[i] > maxSum) maxSum = dp[i];
        }

 
        return maxSum;
    }
}
