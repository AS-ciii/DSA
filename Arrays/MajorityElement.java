// java code to find an majority element which appears n/2 or more times
package Arrays;

import java.util.Scanner;

public class MajorityElement {

    // time complexity is O(n^2)
    public static int MajorityElementBrute(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            int count=0;
            int majority = arr[i];
            for(int j=0; j<arr.length; j++) {
                if(majority == arr[j]) count++;
            }
            if(count >= arr.length/2) return majority;
        }
        return -1;
    }

    // time complexity is O(n) + O(n)
    public static int MajorityElementOptimal(int arr[]) {
        int majority = 0;
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            if(count == 0) {
                majority = arr[i];
                count++;
            }
            else if(majority == arr[i]) count++;
            else count--;
        }
        int count2 = 0;
        for(int i=0; i<arr.length; i++) 
            if(arr[i] == majority) count2++;

        if(count2 >= arr.length/2) return majority;    
        return -1;
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

        int majorityEle = MajorityElementOptimal(numbers);

        if(majorityEle != -1) System.out.println("Majority element is: " +majorityEle); 
        else System.out.println("no majority");
        scanner.close();
    }
}
