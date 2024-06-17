// java code to rotate an array to left by D places

package Arrays;
import java.util.Scanner;

public class LeftRotate {
    // time complexity = O(d) + O(n-d) + O(d) i.e, O(n+d)
    // extra space used is O(d) for temp
    public void LeftRotateBruteForce(int arr[], int D) {
        D = D%arr.length;
        int temp[] = new int[D];

        for(int i=0; i<D; i++) {
            temp[i] = arr[i];
        }

        for(int i=D; i<arr.length; i++) {
            arr[i-D] = arr[i];
        }

        for(int i=0; i<D; i++) {
            arr[arr.length-D+i] = temp[i];
        }
    }
    
    // time complexity is O(2n)
    public void LeftRotateOptimal(int arr[], int D) {
        D = D%arr.length;
        reverse(arr, 0, D-1); // O(d)
        reverse(arr, D, arr.length-1); // O(n-d)
        reverse(arr, 0, arr.length-1); // O(n)
    } 

    public void reverse(int arr[], int start, int end) {
        while(start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int length = scanner.nextInt();

        int numbers[] = new int[length];
        System.out.println("Enter the elements:");
        for(int i=0; i<length; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Enter the number of rotations:");
        int rotate = scanner.nextInt();

        LeftRotate obj = new LeftRotate();
        obj.LeftRotateBruteForce(numbers, rotate);

        System.out.println("After rotation (brute):");
        for(int i=0; i<numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        
        obj.LeftRotateOptimal(numbers, rotate);

        System.out.println("After rotation (optimal):");
        for(int i=0; i<numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        scanner.close();
    }
}
