// java code to find maximum consecutives ones in given array
package Arrays;

import java.util.Scanner;

public class MaxConsecutiveOnes {
    // time complexity is O(n)
    public int MaximumConsecutiveOnes(int arr[]) {
        int maximum = 0;
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 1) {
                count++;
                maximum = Math.max(maximum, count);
            }
            else count=0;
        }
        return maximum;
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

        MaxConsecutiveOnes obj = new MaxConsecutiveOnes();
        int mco = obj.MaximumConsecutiveOnes(numbers);
        System.out.println("Maximum consecutive one's are: "+mco);
        
        scanner.close();
    }
}
