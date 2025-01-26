package Searching;

class Solution {
    public static int findPages(int[] arr, int k) {
        if(k>arr.length) return -1;
        int low = findMax(arr);
        int high = findSum(arr);
        
        while(low<=high) {
            int mid = (low+high)/2;
            
            if(countOfStudents(arr, mid)>k) low = mid+1;
            else high = mid-1;
        }
        
        return low;
    }
    
    static int findMax(int[] arr) {
        int max = arr[0];
        for(int i=1; i<arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    } 
    
    static int findSum(int[] arr) {
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    } 
    
    static int countOfStudents(int arr[], int k) {
        int totStudents = 1;
        int pages = 0;
        
        for(int i=0; i<arr.length; i++) {
            if(pages+arr[i] <= k) pages += arr[i];
            else {
                totStudents++;
                pages = arr[i];
            }    
        }
        
        return totStudents;
    }
    
}
