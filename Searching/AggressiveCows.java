package Searching;

class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        
        int low=1, dist=0;
        int high = stalls[stalls.length-1]-stalls[0];
        
        while(low<=high) {
            int mid=(low+high)/2;
            if(canPlace(stalls, k, mid)) {
                dist = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        
        return dist;
    }
    
    static boolean canPlace(int[] stalls, int k, int min) {
        int count = 1;
        int lastPos = stalls[0];
        
        for(int i=0; i<stalls.length; i++) {
            if(stalls[i]-lastPos>=min) {
                count++;
                lastPos = stalls[i];
                if(count==k) return true;
            }
        }
        return false;
    }
}