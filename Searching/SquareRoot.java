package Searching;

class Solution {
    int floorSqrt(int n) {
        int low = 0;
        int high = n;
        int root = 0;
        while(low<=high) {
            int mid = (low+high)/2;
            if(mid*mid==n) return mid;
            else if(mid*mid<n) {
                root = mid;
                low = mid+1;
            } else high = mid-1;
        }
        
        return root;
    }
}
