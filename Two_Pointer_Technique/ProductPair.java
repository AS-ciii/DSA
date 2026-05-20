class Solution {
    public boolean isProduct(int[] arr, long target) {
        // code here
        int n = arr.length;
        
        Arrays.sort(arr);
        
        int start = 0, end = n - 1;
        
        while (start < end) {
            long prod = 1L * arr[start] * arr[end];
            
            if (prod < target) start++;
            else if (prod > target) end--;
            else return true;
        }
        
        return false;
    }
}
