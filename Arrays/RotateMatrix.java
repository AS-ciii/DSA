// java code to rotate given matrix by 90 degrees
package Arrays;

import java.util.Scanner;

class RotateMatrix {

    // time complexity is O(n^2) + O(n) i.e, O(n^2)
    public static void RotateMatrixby90(int[][] matrix) {
        for(int i=0; i<matrix.length-1; i++) {
            for(int j=i+1; j<matrix.length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        for(int i=0; i<matrix.length; i++) {
            reverse(matrix, i, 0, matrix.length-1);
        }
    }

    public static void reverse(int arr[][], int row, int start, int end) {
        while(start <= end) {
            int temp = arr[row][start];
            arr[row][start] = arr[row][end];
            arr[row][end] = temp;
            start++; end--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows and columns:");
        int n = scanner.nextInt();

        int numbers[][] = new int[n][n];
        System.out.println("Enter the elements:");
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                numbers[i][j] = scanner.nextInt();
            }    
        }

        RotateMatrixby90(numbers);

        System.out.println("After rotating matrix by 90 degree: ");
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(numbers[i][j]);
            }    
            System.out.println("");
        }

        scanner.close();
    }
}