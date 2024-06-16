// Java code for insertion sort
// Insertion sort builds a sorted portion of the list, one element at a time by repeatedly picking the next element and inserting it into its correct position
// worst & avg case time complexity is O(n^2)
// best case time complexity is O(n) if the list is already sorted 

import java.util.Scanner;

public class InsertionSort {
    public void InsertionSortFunction(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            int j=i;
            while(j>0 && arr[j-1] > arr[j]) {
                int temp = arr[j];
                arr[j] =  arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements to be sorted:");
        int length = scanner.nextInt();
        
        int numbers[] = new int[length];

        System.out.println("Enter the numbers to be sorted:");
        for(int i=0; i<length; i++) 
            numbers[i] = scanner.nextInt();

        InsertionSort obj = new InsertionSort();
        obj.InsertionSortFunction(numbers);
        
        System.out.println("After applying insertion sort:");
        for(int i=0; i<length; i++) 
            System.out.println(numbers[i]);

        scanner.close();
    }
}
