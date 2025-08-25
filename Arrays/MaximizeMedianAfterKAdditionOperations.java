class Solution {
    public int maximizeMedian(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
         int medianIndex = (arr.length-1)/2;
        int current = arr[medianIndex];
        
        if(arr.length%2 == 0 && arr[medianIndex+1]-arr[medianIndex] >=k ) {
            return (arr[medianIndex+1]+arr[medianIndex]+k)/2;
        }
        
        // Traverse the second half to increment towards the next distinct values
        for (int i = medianIndex; i < n - 1 && k > 0; i++) {
            int gap = arr[i + 1] - arr[i]; // difference to next larger element
            int count = (i - medianIndex + 1); // number of elements we can raise together
            
            int needed = gap * count;
            
            if (k >= needed) {
                // Raise all these elements to the next one
                current = arr[i + 1];
                k -= needed;
            } else {
                // Distribute remaining k evenly
                current += k / count;
                k = 0;
            }
        }
        
        // If still k left after reaching max element, distribute it equally
        if (k > 0) {
            current += k / (n - medianIndex);
        }
        
        return current;
    }
}
