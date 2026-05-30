class Solution {
    public void replaceElements(int[] arr) {
         int n = arr.length;
         int prev = arr[0];
        // Update first element
        arr[0] = arr[0] ^ arr[1];

        // Update middle elements
        for (int i = 1; i < n - 1; i++) {
            int curr = arr[i];
            arr[i] = prev ^ arr[i + 1];
            prev = curr;
        }

        // Update last element
        arr[n - 1] = prev ^ arr[n - 1];
    }
}
