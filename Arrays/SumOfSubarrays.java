class Solution {
    public int subarraySum(int[] arr) {
        // code here
        int res = 0, n = arr.length;
        for(int i=0;i<n;i++){
            res += arr[i] * (i+1) * (n-i);
        }
        return res;
    }
}
