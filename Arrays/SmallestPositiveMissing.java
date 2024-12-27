package Arrays;

class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            int ele = arr[i];
            int pos = ele-1;
            if(ele>=1 && ele<=arr.length) {
                if(arr[pos] != ele) {
                    int temp = arr[pos];
                    arr[pos] = arr[i];
                    arr[i] = temp;
                    i--;
                }
            }
        }
        
        for(int i=0; i<arr.length; i++) {
            if(i+1 != arr[i]) return i+1;
        }
        
        return arr.length+1;
    }
}
