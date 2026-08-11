class Solution {
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        // code here
        int l1=mat.length,l2=mat[0].length;
        int dp[][]=new int[l1+1][l2+1];
        for(int i=0;i<l1;i++){
            for(int j=0;j<l2;j++){
                dp[i+1][j+1]=mat[i][j]+dp[i][j+1]+dp[i+1][j]-dp[i][j];
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int[] i:queries){
            int row=i[0],col=i[1],s=-1,c=1;
            while(row>=0 && col>=0 && row+c<=l1 && col+c<=l2){
                if(getSquareSum(dp,row,col,c)<=k){
                    s=c;
                    c+=2;
                    row--;
                    col--;
                }
                else break;
            }
            ans.add(s);
        }
        return ans;
    }
    private int getSquareSum(int[][] prefix, int row, int col, int size) {
    int r2 = row + size-1;
    int c2 = col + size-1;

    return prefix[r2+1][c2+1]
         - prefix[row][c2+1]
         - prefix[r2+1][col]
         + prefix[row][col];
    }
}
