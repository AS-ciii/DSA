// java code return total number of subarrays of a given array whose sum equals to target sum k
package Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarraysWithSum {
    
    // time complexity is O(n^2)
    public static int SubarraySumBrute(int[] nums, int k) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            int sum = 0;
            for(int j=i; j<nums.length; j++) {
                sum += nums[j];
                if(sum==k) {
                    count++;
                }
            }
        }
        return count;
    }

    // time complexity is O(n*logn)
    // extra space used in worst case is O(n)
    public static int SubarraySumOptimal(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0; i<nums.length; i++) {
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
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
        
        System.out.println("Enter target sum: ");
        int target = scanner.nextInt();

        int count = SubarraySumOptimal(numbers, target);

        System.out.println("Total subarrays: "+count);

        scanner.close();
    }
}
