class Solution {

    private boolean check(int[] arr, int k, int diff) {
        int count = 1;
        int last = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= diff) {
                count++;
                last = arr[i];
            }
        }
        return count >= k;
    }

    public int maxMinDiff(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;

        int low = 0;
        int high = arr[n - 1] - arr[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(arr, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
