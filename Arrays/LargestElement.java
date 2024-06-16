// java code for finding largest element among given list of integers

package Arrays;
import java.util.Arrays;
import java.util.Scanner;

public class LargestElement {

    // time complexity = TC(sorting) i.e, O(nlogn) if merge sort
    public int LargestElementbyBruteForce(int arr[]) {
        Arrays.sort(arr);
        return arr[arr.length-1]; 
        // return arr[0] for smallest
    }
    
    // time complexity is O(n)
    public int LargestElementOptimal(int arr[]) {
        int largest = arr[0];
        for(int i=1; i<arr.length; i++) {
            // (arr[i] < smallest) for smallest
            if(arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
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

        LargestElement obj = new LargestElement();
        int bruteLargest = obj.LargestElementbyBruteForce(numbers);
        int optimalLargest = obj.LargestElementOptimal(numbers);
        
        System.out.println("Largest number is: " +bruteLargest + "(brute)");
        System.out.println("Largest number is: " +optimalLargest + "(optimal)");

        scanner.close();
    }
}
