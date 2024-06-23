// java code to arrange positive and negative alternates in given array
package Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class PositiveAndNegative {

    // if there are unequal number of positives and negatives in given array
    // time complexity is O(n) + O(n)
    public static int[] PositiveAndNegativeUnequal(int arr[]) {
        ArrayList<Integer> positives = new ArrayList<>(); 
        ArrayList<Integer> negatives = new ArrayList<>(); 

        for(int i=0; i<arr.length; i++) {
            if(arr[i] > 0) positives.add(arr[i]);
            else negatives.add(arr[i]);
        }

        int result[] = new int[arr.length];
        if(positives.size() > negatives.size()) {
            for(int i=0; i<negatives.size(); i++) {
                result[2*i] = positives.get(i);
                result[2*i+1] = negatives.get(i);
            }

            for(int i=negatives.size(); i<positives.size(); i++) {
                result[2*negatives.size()+(i-negatives.size())] = positives.get(i);
            }
        }
        else {
            for(int i=0; i<positives.size(); i++) {
                result[2*i] = positives.get(i);
                result[2*i+1] = negatives.get(i);
            }

            for(int i=positives.size(); i<negatives.size(); i++) {
                result[2*positives.size()+(i-positives.size())] = negatives.get(i);
            }
        }

        return result;
    }

    // if there are equal number of positives and negatives in given array
    // time complexity is O(n)
    public static int[] PositiveAndNegativeEqual(int arr[]) {
        int positive = 0;
        int negative = 1;
        int res[] = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > 0) {
                res[i] = arr[positive];
                positive += 2;
            }
            else {
                res[i] = arr[negative];
                negative += 2;
            }
        }

        return res;
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

        int res[] = PositiveAndNegativeEqual(numbers);

        System.out.println("After sorting:");
        for(int i=0; i<length; i++) {
            System.out.println(res[i]);
        }  

        scanner.close();
    }
}
