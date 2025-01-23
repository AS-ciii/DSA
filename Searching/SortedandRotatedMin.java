package Searching;

class Solution {
    public int findMin(int[] arr) {
        for(int i=0; i<arr.length-1; i++) {
            if(arr[i]>arr[i+1]) return arr[i+1];
        }
        return arr[0];
    }
}
