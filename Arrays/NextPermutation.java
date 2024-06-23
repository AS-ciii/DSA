// java code to find lexographically next permutation of given array
package Arrays;

import java.util.Scanner;

public class NextPermutation {

    // time complexity is O(n) + O(n) + O(n)
    public static int[] FindNextPermutation(int arr[]) {
        int res[] = new int[arr.length];
        int index = -1;
        for(int i=arr.length-2; i>=0; i--) {
            if(arr[i] < arr[i+1]) {
                index = i;
                break;
            }
        }
        if(index == -1) {
            res = reverse(arr, 0, arr.length-1);
            return res;
        }
        for(int i=arr.length-1; i>index; i--) {
            if(arr[i] > arr[index]) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
        res = reverse(arr, index+1, arr.length-1);
        return res;
    }

    public static int[] reverse(int arr[], int start, int end) {
        while(start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
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

        int res[] =FindNextPermutation(numbers);
        System.out.println("Next permutation of given array is:");
        for(int i=0; i<res.length; i++) {
            System.out.println(res[i] + " ");
        }
        
        scanner.close();
    }
}
