package Searching;

class Solution {
    int countFreq(int[] arr, int target) {
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==target) count++;
        }
        return count;
    }
}
