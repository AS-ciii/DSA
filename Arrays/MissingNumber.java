// java code to find missing number is given array of numbers
package Arrays;

import java.util.Scanner;

public class MissingNumber {
    // time complexity is O(n^2)
    public int MissingNumberBrute(int arr[]) {
        for(int i=1; i<=arr.length; i++) {
            int found=0;
            for(int j=0; j<arr.length; j++) {
                if(arr[j] == i) {
                    found = 1;
                    break;
                }
            }
            if(found == 0) return i;
        }
        return -1;
    }
    
    // time complexity is O(n)
    public int MissingNumberOptimal(int arr[]) {
        int sum1 = (arr.length*(arr.length+1))/2;
        int sum2 = 0;
        for(int i=0; i<arr.length; i++) sum2 += arr[i];
        return (sum1-sum2);
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

        MissingNumber obj = new MissingNumber();
        int num = obj.MissingNumberOptimal(numbers);

        if(num > 0 && num < numbers.length) System.out.println("Missing number is: " +num);
        else System.out.println("No missing number");
        
        scanner.close();
    }
}
