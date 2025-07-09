class Solution {
    public int sumSubMins(int[] arr) {
        // code here
        int res = 0;
        for(int i=0; i<arr.length; i++){
            int min = arr[i];
            res += min;
            for(int j=i+1; j<arr.length; j++){
                min = Math.min(min, arr[j]);
                res += min;
            }
        }
        return res;
    }
}
