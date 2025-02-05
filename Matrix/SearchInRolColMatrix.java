package Matrix;

class Solution {
    public static boolean matSearch(int mat[][], int x) {
        for(int i=0; i<mat.length; i++) {
            int low = 0;
            int high = mat[i].length-1;
            
            while(low<=high) {
                int mid = (low+high)/2;
                
                if(mat[i][mid]==x) return true;
                else if(mat[i][mid]<x) low = mid+1;
                else high = mid-1;
            }
        }
        return false;
    }
}
