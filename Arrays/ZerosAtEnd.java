// java code to move all zeroes to the end of array

package Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class ZerosAtEnd {

    // time complexity is O(n) + O(x) + O(n-x) where x is number of non-zero numbers i.e, O(2n)
    // extra space used is O(x) = O(n) if there are no non-zero numbers
    public void ZerosToEndBruteForce(int arr[]) {
        ArrayList<Integer> arrList = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != 0) {
                arrList.add(arr[i]);
            }
        }
        int index=0;
        for(Integer num : arrList) {
            arr[index++] = num;
        }
        for(int i=arrList.size(); i<arr.length; i++) {
            arr[index++] = 0;
        }
    }
    
    // time complexity is O(x) + (n-x) i.e, O(n)
    // no extra space used 
    public void ZerosToEndOptimal(int arr[]) {
        int firstZero = -1;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 0) {
                firstZero = i;
                break;
            }    
        }
        if(firstZero >= 0) {
            for(int i=firstZero+1; i<arr.length; i++) {
                if(arr[i] != 0) {
                    int temp = arr[i];
                    arr[i] = arr[firstZero];
                    arr[firstZero] = temp;
                    firstZero++;
                }
            }
        }    
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
        
        ZerosAtEnd obj = new ZerosAtEnd();
        obj.ZerosToEndBruteForce(numbers);
        obj.ZerosToEndOptimal(numbers);

        System.out.println("After placing zeroes to end");
        for(int i=0; i<numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        scanner.close();
    }
}
