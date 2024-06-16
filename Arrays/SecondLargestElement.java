// java code for finding second largest element among given list of integers

package Arrays;
import java.util.Arrays;
import java.util.Scanner;

public class SecondLargestElement {
    // time complexity is TC(sorting) + TC(for loop) i.e, O(nlogn+n)
    public int SecondLargestElementbyBruteForce(int arr[]) {
        Arrays.sort(arr);
        int largest = arr[arr.length-1];
        int secondLargest = Integer.MIN_VALUE;
       
        for(int i=arr.length-2; i>=0; i--) {
            if(arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }
    
    //time complexity is O(n)
    public int SecondLargestElementOptimal(int arr[]) {
        int largest = arr[0];
        int secondLargest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }
            if(arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
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

        SecondLargestElement obj = new SecondLargestElement();
        int bruteSecondLargest = obj.SecondLargestElementbyBruteForce(numbers);
        int optimalSecondLargest = obj.SecondLargestElementOptimal(numbers);
        
        System.out.println("Second largest number is: " +bruteSecondLargest + "(brute)");
        System.out.println("Second largest number is: " +optimalSecondLargest + "(optimal)");

        scanner.close();
    }
}
