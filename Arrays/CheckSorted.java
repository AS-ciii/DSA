// java code to check if given array is sorted or not

package Arrays;
import java.util.Scanner;

public class CheckSorted {
    //time complexity is O(n)
    public boolean CheckArrayisSorted(int arr[]) {
        for(int i=0; i<arr.length-1; i++) {
            if(arr[i] <= arr[i+1]) {}
            else return false;
        }
        return true;
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
        
        CheckSorted obj = new CheckSorted();
        boolean result = obj.CheckArrayisSorted(numbers);

        if(result) System.out.println("Given array is sorted");
        else System.out.println("Given array is not sorted");
        
        scanner.close();
    }
}
