package Arrays;

class Solution {
    public int maximumProfit(int prices[]) {
        int maxProfit = 0;
        int minimum = prices[0];
        for(int i=1; i<prices.length; i++) {
            int margin = prices[i]-minimum;
            maxProfit = Math.max(maxProfit, margin);
            minimum = Math.min(minimum, prices[i]);
        }
        
        return maxProfit;
    }
}
