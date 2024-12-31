package Arrays;

class Solution {
    // k is the maximum number of zeros allowed to flip
    public int maxOnes(int arr[], int k) {
        int zeroesCount = 0;
        int maxlength = 0;
        int left = 0;
        int right = 0;
        
        while(right<arr.length) {
            if(arr[right]==0) zeroesCount++;
            
            while(zeroesCount>k) {
                if(arr[left]==0) zeroesCount--;
                left++;
            }
            
            int currLength = right-left+1;
            maxlength = Math.max(maxlength, currLength);
            
            right++;
        }
        return maxlength;
    }
}