class Solution {
    int missingNum(int arr[]) {
        int n = arr.length+1;
        int xorFull = 0;
        int xorArr = 0;
        
        for(int i=1; i<=n; i++) xorFull ^= i;
        
        for(int num : arr) xorArr ^= num;
        
        return xorFull^xorArr;
    }
}
