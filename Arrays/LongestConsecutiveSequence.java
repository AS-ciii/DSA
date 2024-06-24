// java code to find longest consecutive sequence in given array

package Arrays;
import java.util.HashSet;
import java.util.Scanner;

class LongestConsecutiveSequence {
    // time complexity is O(n) + O(2n)
    // extra space O(n)
    public static int FindLongestConsecutiveSequence(int arr[]) {
        if(arr.length == 0) return 0;
        int longest = 1;
        HashSet<Integer> Set = new HashSet<>();
        for(int i=0; i<arr.length; i++) Set.add(arr[i]);

        for(int num : Set) {
            if(!Set.contains(num-1)) {
                int count = 1;
                int i = num;
                 while (Set.contains(i + 1)) {
                    i = i + 1;
                    count = count + 1;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
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

        int res = FindLongestConsecutiveSequence(numbers);

        System.out.println("Longest consecutive sequence is: "+res);
        scanner.close();
    }
}
