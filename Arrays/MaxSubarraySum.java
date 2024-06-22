// java code to find maximum possible sum of a subarray in given array
package Arrays;

import java.util.Scanner;

public class MaxSubarraySum {

    // time complexity is O(n^2) 
    public static int MaxSubArraySumBrute(int arr[]) {
        int sum = arr[0];
        int maxSum = arr[0];
        for(int i=1; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
            sum = 0;
        }
        return maxSum;
    }

    // Kadane's algo
    // time complexity is O(n)
    public static int MaxSubArraySumOptimal(int arr[]) {
        int sum = 0;
        int maxSum = arr[0];
        for(int i=0; i<arr.length; i++) {
            if(sum < 0) sum = 0;
            sum += arr[i];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
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

        int maxSum = MaxSubArraySumOptimal(numbers);

        System.out.println("max sum is: " +maxSum);
        scanner.close();
    }
}
