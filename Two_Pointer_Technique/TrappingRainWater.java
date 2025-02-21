package Two_Pointer_Technique;

class Solution {
    public int maxWater(int arr[]) {
        int left = 0;
        int right = arr.length-1;
        
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;
        
        while(left<=right) {
            if(arr[left]<=arr[right]) {
                if(arr[left]>=leftMax) leftMax = arr[left];
                else totalWater += leftMax-arr[left];
                left++;
            } else {
                if(arr[right]>=rightMax) rightMax = arr[right];
                else totalWater += rightMax-arr[right];
                right--;
            }
        }
        
        return totalWater;
    }
}
