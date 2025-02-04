package Matrix;

class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        int top = 0;
        int bottom = mat.length-1;
        int left = 0;
        int right = mat[0].length-1;
        
        ArrayList<Integer> spiral = new ArrayList<>();
        
        while(top<=bottom && left<=right) {
            for(int i=left; i<=right; i++) spiral.add(mat[top][i]);
            top++;
            for(int i=top; i<=bottom; i++) spiral.add(mat[i][right]);
            right--;
            if(top<=bottom) {
                for(int i=right; i>=left; i--) spiral.add(mat[bottom][i]);
                bottom--;
            }
            if(left<=right) {
                for(int i=bottom; i>=top; i--) spiral.add(mat[i][left]);
                left++;
            }    
        }
        
        return spiral;
    }
}
