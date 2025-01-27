package Searching;

class Solution {
    public int kthMissing(int[] arr, int k) {
        int count = 0;
        int i = 1;
        int j = 0;
        
        while(j<arr.length && count<k) {
            if(arr[j]!=i) count++;
            else j++;
            
            i++;
        }
        
        if(k==count) return i-1;
        else return (arr[arr.length-1]+(k-count));
    }
}