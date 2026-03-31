class Solution {
    public int maxProfit(int arr[], int k) {

        int n = arr.length;
        int hold = -arr[0];   // profit if holding a stock
        int notHold = 0;         // profit if not holding a stock

        for (int i = 1; i < n; i++) {
            hold = Math.max(hold, notHold - arr[i]); 
            notHold = Math.max(notHold, hold + arr[i] - k);
        }

        return notHold;

    }
}
