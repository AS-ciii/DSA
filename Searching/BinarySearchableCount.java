
class Solution {
    public int binarySearchable(int[] arr) {
        int n = arr.length;
        int count = 0;

        for (int targetIndex = 0; targetIndex < n; targetIndex++) {

            int target = arr[targetIndex];

            int l = 0;
            int r = n - 1;
            boolean found = false;

            while (l <= r) {
                int mid = l + (r - l) / 2;

                if (arr[mid] == target) {
                    found = true;
                    break;
                } else if (arr[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            if (found) {
                count++;
            }
        }

        return count;
    }
}
