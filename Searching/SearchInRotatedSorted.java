package Searching;

class Solution {
    int search(int[] arr, int key) {
        int low = 0;
        int high = arr.length-1;
        
        while(low<=high) {
            int mid = (low+high)/2;
            
            if(arr[mid]==key) return mid;
            
            if(arr[low]<=arr[mid]) {
                if(arr[low]<=key && key<arr[mid]) high=mid-1;
                else low=mid+1;
            } else {
                if(arr[mid]<key && key<=arr[high]) low=mid+1;
                else high=mid-1;
            }
        }
        return -1; 
    }
}

