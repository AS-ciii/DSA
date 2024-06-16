// java code to return an array eliminating all its duplicate elements

package Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates {
    // time complexity = TC(set insertion) + TC(array insertion) i.e, O(nlogn+n)
    public int[] RemoveDuplicatesbyBruteForce(int arr[]) {
        HashSet<Integer> numSet = new HashSet<>();
        for(Integer num : arr) {
            numSet.add(num);
        }
        int newarr[] = new int[numSet.size()];
        int index=0;
        for(Integer num : numSet) {
            newarr[index] = num;
            index++;
        }
        return newarr;
    }
    
    //time complexity is O(n)
    public int RemoveDuplicatesOptimal(int arr[]) {
        int i=0;
        for(int j=1; j<arr.length; j++) {
            if(arr[i] != arr[j]) {
                arr[i+1] = arr[j];
                i++;            
            }
        }
        return i+1;
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

        RemoveDuplicates obj = new RemoveDuplicates();
        int noDupBrute[] = obj.RemoveDuplicatesbyBruteForce(numbers);
        int noDupOptimal = obj.RemoveDuplicatesOptimal(numbers);

        System.out.println("Array after removing duplicates (brute):");
        for(int i=0; i<noDupBrute.length; i++) System.out.println(noDupBrute[i]);
        System.out.println("Array after removing duplicates (optimal):");
        for(int i=0; i<noDupOptimal; i++) System.out.println(numbers[i]);

        scanner.close();
    }
}
