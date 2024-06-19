// java code to find sum c=a+b where a and b are array elements in different indices

package Arrays;

import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
    
    // time complexity is O(n^2)
    public static int[] TwoSumBrute(int arr[], int target) {
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i]+arr[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }
    
    // time complexity is O(n) + O(n) i.e O(2n) approx O(n)
    // extra space used is O(n) for map 
    public static int[] TwoSumOptimal(int arr[], int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++) map.put(arr[i], i);
        for(int i=0; i<arr.length; i++) {
            int num = arr[i];
            Integer rem = target-num;
            if(map.containsKey(rem) && map.get(rem)!=i) return new int[]{i, map.get(rem)};
        }
        return new int[]{-1, -1};
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

        System.out.println("Enter target Sum");
        int target = scanner.nextInt();

        int res[] = TwoSumOptimal(numbers, target);

        if(res[0] != -1)  System.out.println("The indices are: " + res[0] + " & " + res[1]);
        else System.out.println("None met target sum");

        scanner.close();
    }
}
