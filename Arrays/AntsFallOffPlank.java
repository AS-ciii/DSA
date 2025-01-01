package Arrays;

class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        int maxLeft = 0;
        int maxRight = 0;
        int sec = 0;
        
        for(int i=0; i<left.length; i++) {
            int currLeft = left[i];
            maxLeft = Math.max(maxLeft, currLeft);
        }
        
        for(int i=0; i<right.length; i++) {
            int currRight = n-right[i];
            maxRight = Math.max(maxRight, currRight);
        }
        
        sec = Math.max(maxLeft, maxRight);
        return sec;
    }
}
