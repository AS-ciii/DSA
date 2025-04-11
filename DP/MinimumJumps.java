package DP;

class Solution {
    static int minJumps(int[] arr) {
        if(arr.length <= 1) return 0;
        if(arr[0]==0) return -1;
        
        
        int jumps = 0;
        int farthest = 0;
        int currentEnd = 0;
        
        for(int i=0; i<arr.length-1; i++) {
            farthest = Math.max(farthest, i+arr[i]);
            
            if(i==currentEnd) {
                jumps++;
                currentEnd = farthest;
                
                if(currentEnd >= arr.length-1) return jumps;
            }
        }
        
        return -1;
    }
}
