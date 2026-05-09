class Solution {
    
    public int countSpanTree(int n, int[][] edges) {
        
        if(n == 1) return 1;

        int[][] lap = new int[n][n];
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            lap[u][u]++;
            lap[v][v]++;
            lap[u][v]--;
            lap[v][u]--;
        }
        double[][] mat = new double[n - 1][n - 1];
        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                mat[i - 1][j - 1] = lap[i][j];
            }
        }
        long det = determinant(mat, n - 1);
        return (int)Math.round(det);
    }
    private long determinant(double[][] mat, int size){
        double det = 1;
        for(int i = 0; i < size; i++){
            int pivot = i;
            for(int j = i; j < size; j++){
                if(Math.abs(mat[j][i]) > Math.abs(mat[pivot][i])){
                    pivot = j;
                }
            }
            if(Math.abs(mat[pivot][i]) < 1e-9){
                return 0;
            }
            if(i != pivot){
                double[] temp = mat[i];
                mat[i] = mat[pivot];
                mat[pivot] = temp;
                det *= -1;
            }

            det *= mat[i][i];
            for(int j = i + 1; j < size; j++){
                double factor = mat[j][i] / mat[i][i];
                for(int k = i; k < size; k++){
                    mat[j][k] -= factor * mat[i][k];
                }
            }
        }

        return Math.round(det);
    }
}

