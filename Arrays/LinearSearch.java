// java code to implement linear/sequential search

package Arrays;

import java.util.Scanner;

public class LinearSearch {
    // time complexity for worst & avg case is O(n)
    // time complexity for best case is O(1)
    public int LinearSearchFunction(int arr[], int Key) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == Key) return i;
        }
        return -1;
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
        
        System.out.println("Enter the element to be searched");
        int key = scanner.nextInt();

        LinearSearch obj = new LinearSearch();
        int result = obj.LinearSearchFunction(numbers, key);

        if(result >= 0) System.out.println("Element found at index " +result);
        else System.out.println("Element not found");
        
        scanner.close();
    }
}
