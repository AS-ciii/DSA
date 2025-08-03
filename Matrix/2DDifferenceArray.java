class Solution {
    public ArrayList<ArrayList<Integer>> applyDiff2D(int[][] mat, int[][] opr) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        for(int n=0;n<opr.length;n++){
            int num=opr[n][0];
            int istart=opr[n][1];
            int jstart=opr[n][2];
            int iend=opr[n][3];
            int jend=opr[n][4];
            for(int i=istart;i<=iend;i++){
                for(int j=jstart;j<=jend;j++){
                    mat[i][j]+=num;
                }
            }
        }
        for(int i=0;i<mat.length;i++){
            ArrayList<Integer> ans=new ArrayList<Integer>();
            for(int j=0;j<mat[0].length;j++){
                ans.add(mat[i][j]);
            }
            res.add(ans);
        }
        
        return res;
    }
}
