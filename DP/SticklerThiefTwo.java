package DP;


class Solution {
    int maxValue(int[] arr) {
        if(arr.length==0) return 0;
        if(arr.length==1) return arr[0];
        
        return Math.max(rob(arr, 0, arr.length-2), rob(arr, 1, arr.length-1));
        
    }
    
    int rob(int arr[], int start, int end) {
        int p1 = 0;
        int p2 = 0;
        
        for(int i=start; i<=end; i++) {
            int curr = Math.max(p1, arr[i]+p2);
            p2 = p1;
            p1 = curr;
        }
        
        return p1;
    }
}
