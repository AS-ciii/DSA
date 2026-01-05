class Solution {
    public int maxSubarraySum(int[] nums, int k) {
       int windowSum = 0;
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum = windowSum + nums[i];
        }
        maxSum = windowSum;
        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
}
