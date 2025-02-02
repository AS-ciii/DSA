package Searching;

class Solution {
    public static int minDaysBloom(int m, int k, int[] arr) {
        
        if(m*k>arr.length) return -1;
        int low = min(arr);
        int high = max(arr);
        
        while(low<=high) {
            int mid = (low+high)/2;
            
            boolean res = checkForDay(arr, mid, m, k);
            
            if(res) high = mid-1;
            else low = mid+1;
        }
        
        return low;
    }
    
    static boolean checkForDay(int[] arr, int mid, int m, int k) {
        int count1 = 0;
        int count2 = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i]<=mid) count1++;
            else count1 = 0;
            
            if(count1>=k) {
                count2 += count1/k;
                count1 = 0;
            }    
        }
        
        if(count2>=m) return true;
        else return false;
    }
    
    static int min(int[] arr) {
        int min = arr[0];
        for(int i=1; i<arr.length; i++) min = Math.min(min, arr[i]);
        return min;
    }
    
    static int max(int[] arr) {
        int max = arr[0];
        for(int i=1; i<arr.length; i++) max = Math.max(max, arr[i]);
        return max;
    }
}
