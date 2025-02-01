package Searching;

class Solution {
    public static int kokoEat(int[] arr, int k) {
        int low = 1;
        int high = max(arr);
        
        while(low<=high) {
            int mid = (low+high)/2;
            
            boolean res = canEat(arr, k, mid);
            
            if(res) high = mid-1;
            else low = mid+1;
        }
        
        return low;
    }
    
    static boolean canEat(int[] arr, int k, int mid) {
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            count += (arr[i]+mid-1)/mid; 
        }
        return count<=k;
    }

    static int max(int[] arr) {
        int max = arr[0];
        for(int i=1; i<arr.length; i++) max = Math.max(max, arr[i]);
        return max;
    }
}