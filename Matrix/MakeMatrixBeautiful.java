class Solution {
    public static int balanceSums(int[][] mat) {
        int n=mat.length;
         int[] rowSum = new int[n];
        int[] colSum = new int[n];
        int maxSum = 0;

        // Calculate row sums and column sums
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
            }
        }

        // Find the maximum sum among rows and columns
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, rowSum[i]);
            maxSum = Math.max(maxSum, colSum[i]);
        }

        // Calculate total number of operations needed
        int operations = 0;
        for (int i = 0; i < n; i++) {
            operations += maxSum - rowSum[i];
        }

        return operations;
    }
}
