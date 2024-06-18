// java code to find union of two arrays

package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class FindUnion {

    // time complexity is O(n1logn) + O(n2logn) + O(n1+n2)
    // extra space utilized is O(n1+n2)[for set in worst case] + O(n1+n2)[for returning ans]
    public int[] ArrayUnionBruteForce(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }

        for(int i=0; i<arr2.length; i++) {
            set.add(arr2[i]);
        }

        int Union[] = new int[set.size()];
        int index = 0;

        for(Integer num : set) {
            Union[index++] = num;
        }
        return Union;
    }
    
    // time complexity is O(n1+n2)
    public int[] ArrayUnionOptimal(int arr1[], int arr2[]) {
        ArrayList<Integer> Union = new ArrayList<>();
        int i=0, j=0;
        while(i<arr1.length && j<arr2.length) {
            if(arr1[i]<=arr2[j]) {
                if(Union.size() == 0 || !Union.get(Union.size() - 1).equals(arr1[i])) {
                    Union.add(arr1[i]);
                }
                i++;
            } else {
                if(Union.size() == 0 || !Union.get(Union.size() - 1).equals(arr2[j])) {
                    Union.add(arr2[j]);
                }
                j++;
            }
        }
        while(i<arr1.length) {
            if (Union.size() == 0 || !Union.get(Union.size() - 1).equals(arr1[i])) {
                Union.add(arr1[i]);
            }
            i++;
        }
        while(j<arr2.length) {
            if (Union.size() == 0 || !Union.get(Union.size() - 1).equals(arr2[j])) {
                Union.add(arr2[j]);
            }
            j++;
        }
        int[] arrayUnion = Union.stream().mapToInt(Integer::intValue).toArray();
        return arrayUnion;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in array 1:");
        int m = scanner.nextInt();

        int array1[] = new int[m];
        System.out.println("Enter the elements of array 1:");
        for(int i=0; i<m; i++) {
            array1[i] = scanner.nextInt();
        }

        System.out.println("Enter the number of elements in array 2:");
        int n = scanner.nextInt();

        int array2[] = new int[n];
        System.out.println("Enter the elements of array 2:");
        for(int i=0; i<n; i++) {
            array2[i] = scanner.nextInt();
        }
        
        FindUnion obj = new FindUnion();
        int Union[] = obj.ArrayUnionOptimal(array1, array2);

        System.out.println("Union of both arrays is:");
        for(int i=0; i<Union.length; i++) {
            System.out.println(Union[i]);
        }

        scanner.close();
    }
}
