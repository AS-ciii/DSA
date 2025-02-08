package Matrix;

class Solution {
    public static int findMinOperation(int[][] mat) {
        int len = mat.length;
        int[] rowSum = new int[len];
        int[] colSum = new int[len];
        int count = 0;
        
        for(int i=0; i<len; i++) {
            rowSum[i] = findRowSum(mat, i, len);
            colSum[i] = findColSum(mat, i, len);
        }
        
        int maxSum = 0;
        
        for(int i=0; i<rowSum.length; i++) {
            maxSum = Math.max(maxSum, Math.max(rowSum[i], colSum[i]));
        }
        
        for(int i=0; i<rowSum.length; i++) {
            count += (maxSum-rowSum[i]);
        }
        
        return count;
    }
    
    public static int findRowSum(int[][] mat, int idx, int len) {
        int sum = 0;
        for(int i=0; i<len; i++) {
            sum += mat[idx][i];
        }
        return sum;
    }
    
    public static int findColSum(int[][] mat, int idx, int len) {
        int sum = 0;
        for(int i=0; i<len; i++) {
            sum += mat[i][idx];
        }
        return sum;
    }
}
