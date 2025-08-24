class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        // code here
        int n = arr.length;
        if(n < (m*k)){
            return -1;
        }
        Arrays.sort(arr);
        return arr[(m*k) - 1];
    }
}
