package Arrays;

class Solution {
    public int getSecondLargest(int[] arr) {
        int largest = arr[0];
        int secondLargest = -1;
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if(arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}

