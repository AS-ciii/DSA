class Solution {
    public static boolean isPossible(int[] arr, int n, int k, int w, int target) {
        int[] diff = new int[n + 1];
        long used = 0;
        int add = 0;

        for (int i = 0; i < n; i++) {
            add += diff[i];
            int currHeight = arr[i] + add;

            if (currHeight < target) {
                int need = target - currHeight;
                used += need;
                if (used > k) return false;

                add += need;
                if (i + w < n) {
                    diff[i + w] -= need;
                }
            }
        }

        return true;
    }

    public static int maxMinHeight(int[] arr, int k, int w) {
        int n = arr.length;
        int low = Integer.MAX_VALUE;
        int high = 0;

        for (int height : arr) {
            low = Math.min(low, height);
            high = Math.max(high, height);
        }

        high += k;
        int answer = low;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(arr, n, k, w, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }
}
