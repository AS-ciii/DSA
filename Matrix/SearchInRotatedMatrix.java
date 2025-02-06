package Matrix;

class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchMatrix(int[][] mat, int x) {
        int low = 0;
        int high = (mat.length*mat[0].length)-1;
        
        while(low<=high) {
            int mid = (low+high)/2;
            
            int row = mid/mat[0].length;
            int col = mid%mat[0].length;
            
            if(mat[row][col]==x) return true;
            else if(mat[row][col]>x) high = mid-1;
            else low = mid+1;
        }
        
        return false;
    }
}
