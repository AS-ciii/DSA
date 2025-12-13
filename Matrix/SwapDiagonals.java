class Solution {
    public void swapDiagonal(int[][] mat) {
        // code here
        int n=mat.length-1;
        int m= mat[0].length;
        for(int i=0;i<mat.length;i++){
            int j=n-i;
            //System.out.println(i + " "+j)
                //System.out.println(i + " "+j);
                int a=mat[i][i];
                mat[i][i]=mat[i][j];
                mat[i][j]=a;
            
        }
    }
}
