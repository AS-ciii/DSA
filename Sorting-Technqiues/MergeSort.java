// Java code for merge sort
// merge sort is divide and conquer algo that recursively splits a list into halves, sorts each of them and finally merges the sorted halves to get a fully sorted list
// worst, avg & best case time complexity is O(nlogn)

import java.util.Scanner;

public class MergeSort {
    public void Merge(int arr[], int low, int mid, int high) {
        int temp[] = new int[arr.length];
        int left=low, right=mid+1;
        int i=0;

        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                temp[i] = arr[left];
                left++; i++;
            } else {
                temp[i] = arr[right];
                right++; i++;
            }
        }

        while(left <= mid) {
            temp[i] = arr[left];
            left++; i++;
        }

        while(right <= high) {
            temp[i] = arr[right];
            right++; i++;
        }

        for(int j=low; j<=high; j++) {
            arr[j] = temp[j-low];
        }
    }

    public void MergeSortFunction(int arr[], int low, int high) {
        if(low==high) return;
        int mid = (low+high)/2;
        MergeSortFunction(arr, low, mid);
        MergeSortFunction(arr, mid+1, high);
        Merge(arr, low, mid, high);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements to be sorted");
        int length = scanner.nextInt();

        int numbers[] = new int[length];

        System.out.println("Enter the numbers to be sorted:");
        for(int i=0; i<length; i++) 
            numbers[i] = scanner.nextInt();

        MergeSort obj = new MergeSort();
        obj.MergeSortFunction(numbers, 0, length-1); 
        
        System.out.println("After applying merge sort:");
        for(int i=0; i<length; i++)
            System.out.println(numbers[i]);

        scanner.close();
    }
}
