// java code to check best time to buy and sell stocks to earn max profit
package Arrays;

import java.util.Scanner;

public class BuyAndSellStocks {

    // time complexity is O(n)
    public static int CalcProfit(int arr[]) {
        int buy = arr[0];
        int profit = 0;
        int maxProfit = 0;
        for(int i=1; i<arr.length; i++) {
            profit = arr[i] - buy;
            maxProfit = Math.max(maxProfit, profit);
            buy = Math.min(arr[i], buy);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of days:");
        int days = scanner.nextInt();

        int prices[] = new int[days];
        System.out.println("Enter the prices:");
        for(int i=0; i<days; i++) {
            prices[i] = scanner.nextInt();
        }

        int profit = CalcProfit(prices);

        System.out.println("Profit earned is: " +profit);

        scanner.close();
    }
}
