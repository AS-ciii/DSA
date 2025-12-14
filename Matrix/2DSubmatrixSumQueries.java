class Solution {
    int solve(int [][]mat,int [][]queries,int i){
        int sum=0;
        if(i>=queries.length){
            return 0;
        }
         for(int k=queries[i][0];k<=queries[i][2];k++){
                for(int j=queries[i][1];j<=queries[i][3];j++){
                    sum+=mat[k][j];
                }
         }
        //  solve(mat,queries,i+1);
         return sum;
        
    }
    
    public ArrayList<Integer> prefixSum2D(int[][] mat, int[][] queries) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        // for(int i=0;i<queries.length;i++){
        //     ans.add(solve(mat,queries,i));
        // }
        // return ans;
         for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i > 0) mat[i][j] += mat[i - 1][j];
                if (j > 0) mat[i][j] += mat[i][j - 1];
                if (i > 0 && j > 0) mat[i][j] -= mat[i - 1][j - 1];
            }
        }

        int i = 0;
        while (i < queries.length) {
            int r1 = queries[i][0];
            int c1 = queries[i][1];
            int r2 = queries[i][2];
            int c2 = queries[i][3];

            int sum = mat[r2][c2];
            if (r1 > 0) sum -= mat[r1 - 1][c2];
            if (c1 > 0) sum -= mat[r2][c1 - 1];
            if (r1 > 0 && c1 > 0) sum += mat[r1 - 1][c1 - 1];

            ans.add(sum);
            i++;
        }

        return ans;
    }
}
