class Solution {
    public int subarrayXor(int[] arr) {
        // code here
        int n = arr.length;
        int total = 0;
        for(int i=0;i<n;i++){
            long freq = (long)(i+1)*(n-i);
            if(freq%2 != 0) total ^=arr[i];
        }
        return total;
    }
}
