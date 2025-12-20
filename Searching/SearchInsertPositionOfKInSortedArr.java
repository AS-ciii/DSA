class Solution {
    public int searchInsertK(int arr[], int k) {
        // formula: mid = (start + (end - start)) / 2
        int start = 0, end = arr.length-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < k) { 
                start = mid + 1;
            } else { 
                end = mid - 1; 
            }
        }
        return start;
    }
};

