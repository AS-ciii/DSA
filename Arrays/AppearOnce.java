// java code to find number which appears only once among other numbers that appear twice
package Arrays;

import java.util.Scanner;

public class AppearOnce {
    // time complexity is O(n^2)
    public int AppearOnceBruteForce(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            int count = 0;
            for(int j=0; j<arr.length; j++) {
                if(arr[j] == arr[i]) count++;
            }
            if(count == 1) return arr[i];
        }
        return -1;
    }

    // time complexity is O(n)
    public int AppearOnceOptimal(int arr[]) {
        int XOR = 0;
        for(int i=0; i<arr.length; i++) XOR = XOR^arr[i];
        return XOR;
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
        
        AppearOnce obj = new AppearOnce();
        int num = obj.AppearOnceOptimal(numbers);
        if(num > 0) System.out.println("Number that appear once is " +num);
        else System.out.println("No Number appear just once");
        scanner.close();
    }
}
