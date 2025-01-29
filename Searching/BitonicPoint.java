package Searching;

class Solution {
    public int findMaximum(int[] arr) {
        for(int i=1; i<arr.length; i++) {
            if(arr[i]<arr[i-1]) return arr[i-1];
        }
        
        return arr[arr.length-1];
    }
}
