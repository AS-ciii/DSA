class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // code here
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                arr.add(matrix[i][j]);
            }
        }
        
        arr.sort(null);
        
        return arr.get(k-1);
    }
}
