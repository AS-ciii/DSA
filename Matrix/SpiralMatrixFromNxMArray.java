package Matrix;

class Solution {
    public int[][] spiralFill(int n, int m, int[] arr) {
        int[][] res = new int[n][m];
        int top = 0;
        int left = 0;
        int bottom = n-1;
        int right = m-1;
        int index = 0;
        
        while(top<=bottom && left<=right) {
            for(int i=left; i<=right; i++) {
                res[top][i] = arr[index];
                index++;
            }
            top++;
            
            for(int j=top; j<=bottom; j++) {
                res[j][right] = arr[index];
                index++;
            }
            right--;
            
            if(top<=bottom) {
                for(int k=right; k>=left; k--) {
                res[bottom][k] = arr[index];
                index++;
                }
                bottom--;
            }
            
            if(left<=right) {
                for(int l=bottom; l>=top; l--) {
                res[l][left] = arr[index];
                index++;
                }
                left++;
            }
        }
        
        return res;
    }
}
