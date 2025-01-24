package Searching;

class Solution {

    public int peakElement(int[] arr) {
        if(arr.length==1) return 0;
        if(arr[0] > arr[1]) return 0;
        for(int i=1; i<arr.length-1; i++) {
            if(arr[i]>arr[i-1] && arr[i]>arr[i+1]) return i;
        }
        
        if(arr[arr.length-1]>arr[arr.length-2]) return arr.length-1;
        
        return -1;
    }
}
