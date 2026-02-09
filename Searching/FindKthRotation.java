class Solution {
    public int findKRotation(int arr[]) {
        int low = 0, high = arr.length - 1;
        int ans = 0;
        int min = Integer.MAX_VALUE;

        while (low <= high) {

            if (arr[low] <= arr[high]) {
                if (arr[low] < min) {
                    min = arr[low];
                    ans = low;
                }
                break;
            }

            int mid = low + (high - low) / 2;

            if (arr[low] <= arr[mid]) {
                if (arr[low] < min) {
                    min = arr[low];
                    ans = low;
                }
                low = mid + 1;
            }
            else {
                if (arr[mid] < min) {
                    min = arr[mid];
                    ans = mid;
                }
                high = mid - 1;
            }
        }
        return ans;
    }
}
