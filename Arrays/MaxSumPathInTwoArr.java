class Solution {
    public int maxPathSum(int[] a, int[] b) {

        int i = 0, j = 0;

        int sum1 = 0;
        int sum2 = 0;
        int ans = 0;

        while (i < a.length && j < b.length) {

            if (a[i] < b[j]) {
                sum1 += a[i];
                i++;
            } 
            else if (a[i] > b[j]) {
                sum2 += b[j];
                j++;
            } 
            else {
                // Common element
                ans += Math.max(sum1, sum2) + a[i];

                sum1 = 0;
                sum2 = 0;

                i++;
                j++;
            }
        }

        while (i < a.length) {
            sum1 += a[i++];
        }

        while (j < b.length) {
            sum2 += b[j++];
        }

        ans += Math.max(sum1, sum2);

        return ans;
    }
}
