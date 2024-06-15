// Java code for selection sort
// selects a minimum from unsorted portion of the array and swaps it with element at current position. repeats until given array is sorted
// worst, avg & best case time complexity is O(n^2)

import java.util.Scanner;

public class SelectionSort {
    public void SelectionSortFunction(int arr[]) {
        for(int i=0; i<arr.length-1; i++) {
            int minimum = i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] < arr[minimum]) {
                    minimum = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minimum];
            arr[minimum] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the numbers of elements to be sorted:");
        int length = scanner.nextInt();

        int numbers[] = new int[length];
        
        System.out.println("Enter the numbers to be sorted:");
        for(int i=0; i<length; i++) 
            numbers[i] = scanner.nextInt();
        
        SelectionSort obj = new SelectionSort();
        obj.SelectionSortFunction(numbers);

        System.out.println("After applying selection sort:");    
        for(int i=0; i<length; i++) 
            System.out.println(numbers[i]);  

        scanner.close();
    }
}