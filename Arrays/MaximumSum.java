package Arrays;

class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {
        int sum = 0;
        int maximum = Integer.MIN_VALUE;
        
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            
            if(sum > maximum) maximum = sum;
            
            if(sum < 0) sum = 0;
        }
        return maximum;
    }
}
