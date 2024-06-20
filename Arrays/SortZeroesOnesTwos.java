// java code to sort an array containing only 0's, 1's and 2's
package Arrays;
import java.util.Arrays;
import java.util.Scanner;

public class SortZeroesOnesTwos {

    // time complexity is O(nlogn) if merge sort is used to sort
    // extra space O(n) is used in merge sort
    public static void SortBrute(int arr[]) {
        Arrays.sort(arr);
    }
    
    // time complexity is O(n) + O(n) i.e, O(2n)
    public static void SortBetter(int arr[]) {
        int countZeroes=0, countOnes=0, countTwos=0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 0) countZeroes++;
            else if(arr[i] == 1) countOnes++;
            else countTwos++;
        }
        int index = 0;
        for(int i=0; i<countZeroes; i++) arr[index++] = 0;
        for(int i=0; i<countOnes; i++) arr[index++] = 1;
        for(int i=0; i<countTwos; i++) arr[index++] = 2;
    }
    
    // dutch national flag algo
    // time complexity is O(n)
    public static void SortOptimal(int arr[]) {
        int low=0, mid=0, high=arr.length-1;
        while (mid <= high) {
            if(arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if(arr[mid] == 1) mid++;
            else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
        
        SortOptimal(numbers);
        for(int i=0; i<numbers.length; i++) System.out.println(numbers[i]);
        scanner.close();
    }
}