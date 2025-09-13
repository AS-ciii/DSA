public class Solution {
    public int minCost(int n, int m, int[] x, int[] y) {
        // Sort ascending first
        Arrays.sort(x);
        Arrays.sort(y);

        // Reverse arrays to get descending order
        reverse(x);
        reverse(y);

        int i = 0, j = 0;
        int horizontalSegments = 1, verticalSegments = 1;
        long totalCost = 0L;

        while (i < x.length && j < y.length) {
            if (x[i] >= y[j]) {
                totalCost += (long) x[i] * horizontalSegments;
                verticalSegments++;
                i++;
            } else {
                totalCost += (long) y[j] * verticalSegments;
                horizontalSegments++;
                j++;
            }
        }

        while (i < x.length) {
            totalCost += (long) x[i] * horizontalSegments;
            verticalSegments++;
            i++;
        }

        while (j < y.length) {
            totalCost += (long) y[j] * verticalSegments;
            horizontalSegments++;
            j++;
        }

        return (int) totalCost;
    }

    private void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
