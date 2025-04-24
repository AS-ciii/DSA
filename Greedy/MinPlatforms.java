package Greedy;

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int n = arr.length;
        int pt = 1;
        int maxPt = 1;
        int i = 1;
        int j = 0;
        
        while(i<n && j<n) {
            if(arr[i] <= dep[j]) {
                pt++; i++;
            } else {
                pt--;
                j++;
            }
            
            maxPt = Math.max(maxPt, pt);
        }
        
        return maxPt;
    }
}