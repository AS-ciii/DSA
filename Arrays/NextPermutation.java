class Solution {
    void nextPermutation(int[] arr) {
        int breakPoint = -1;
        for(int i=arr.length-2; i>=0; i--) {
            if(arr[i] < arr[i+1]) {
                breakPoint = i;
                break;
            }
        }
        if(breakPoint == -1) {
            reverseArr(arr, 0, arr.length-1);
        } else {
            for(int i=arr.length-1; i>=breakPoint; i--) {
                if(arr[i] > arr[breakPoint]) {
                    int temp = arr[i];
                    arr[i] = arr[breakPoint];
                    arr[breakPoint] = temp;
                    break;
                }
            }
            
            reverseArr(arr, breakPoint+1, arr.length-1);
        }
    }
    
    static void reverseArr(int arr[], int start, int end) {
        int temp;
        while(start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
