// java code to set entire row and column to zero in a matrix if a element 0 is found 

package Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

class SetMatrixZero {

    // time complexity is O(n*m)
    public static void setZeroes(int[][] matrix) {
        Queue<int[]> q = new LinkedList<>();
        int n =matrix.length;
        int m=matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    q.add(new int[]{ i,j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] it = q.poll();
            int r = it[0];
            int c = it[1];
            for(int i=0;i<m;i++){
                matrix[r][i]=0;
            }
            for(int i=0;i<n;i++){
                matrix[i][c]=0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows: ");
        int m = scanner.nextInt();

        System.out.println("Enter the number of columns: ");
        int n = scanner.nextInt();

        int matrix[][] = new int[m][n];
        System.out.println("Enter the elements:");
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = scanner.nextInt();
            }    
        }

        setZeroes(matrix);

        System.out.println("After setting row & col to zero:");
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                System.err.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
