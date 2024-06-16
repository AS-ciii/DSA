// Java code for quick sort
// quick sort is a divide and conquer algo that focuses on selecting a pivot, partitioning the array into two containing elements less than and greater than pivot respectively and then recursively sorts those partitions
// worst case time complexity is O(n^2) which occurs due to poor pivot selection
// best & avg case time complexity is O(nlogn)

import java.util.Scanner;

public class QuickSort {
    public int Partition(int arr[], int low, int high) {
        int pivot=arr[low];
        int i=low, j=high;
        while(i < j) {
            while(arr[i] <= pivot && i<high) i++;
            while(arr[j] > pivot && j>low) j--;
            if(i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

    public void QuickSortFunction(int arr[], int low, int high) {
        if(low < high) {
            int PartitionIndex = Partition(arr, low, high);
            QuickSortFunction(arr, low, PartitionIndex-1);
            QuickSortFunction(arr, PartitionIndex+1, high);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements to be sorted");
        int length = scanner.nextInt();

        int numbers[] = new int[length];

        System.out.println("Enter the numbers to be sorted:");
        for(int i=0; i<length; i++) 
            numbers[i] = scanner.nextInt();

        QuickSort obj = new QuickSort();
        obj.QuickSortFunction(numbers, 0, length-1); 
        
        System.out.println("After applying quick sort:");
        for(int i=0; i<length; i++)
            System.out.println(numbers[i]);

        scanner.close();
    }
}
