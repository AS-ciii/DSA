// Java code for bubble sort
// Bubble sort repeatedly steps through the list, compares adjacent elements, swaps them if they are in the wrong order. Continues until no more swaps are needed
// worst & avg case time complexity is O(n^2)
// best case time complexity after adding didSwap is O(n) if list is already sorted

import java.util.Scanner;

public class BubbleSort {
    public void BubbleSortFunction(int arr[]) {
        for(int i=0; i<arr.length-1; i++) {
            boolean didSwap = false;
            for(int j=0; j<arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    didSwap = true;
                }
            }
            if(!didSwap) break;
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

        BubbleSort obj = new BubbleSort();
        obj.BubbleSortFunction(numbers);
        
        System.out.println("After applying bubble sort");
        for(int i=0; i<length; i++) 
            System.out.println(numbers[i]);

        scanner.close();
    }
}

