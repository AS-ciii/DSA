class Solution {
    public int maxRectSum(int[][] M) {
        int R = M.length;
        int C = M[0].length;
        int maxSum = Integer.MIN_VALUE;

        for (int left = 0; left < C; left++) {
            int[] temp = new int[R];

            for (int right = left; right < C; right++) {
                for (int i = 0; i < R; i++) {
                    temp[i] += M[i][right];
                }

                int currentMax = kadane(temp);
                maxSum = Math.max(maxSum, currentMax);
            }
        }

        return maxSum;
    }

    private int kadane(int[] arr) {
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
