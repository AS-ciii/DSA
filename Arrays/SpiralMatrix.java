// java code to get spiraled order of m*n matrix
package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralMatrix {

    // time complexity is O(m*n)
    // extra space used is O(m*n)
    public static List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int right = matrix[0].length-1;
        int bottom = matrix.length-1;
        int left = 0;
        List<Integer> list = new ArrayList<>();

        while(top <= bottom && left <= right) {
            for(int i=left; i<=right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            for(int i=top; i<=bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if(top <= bottom) {
                for(int i=right; i>=left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left <= right) {
                for(int i=bottom; i>=top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
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

        List<Integer> spiraled = spiralOrder(matrix);

        for(Integer num : spiraled) {
            System.out.print(num + " ");
        }
        scanner.close();
    }
}

