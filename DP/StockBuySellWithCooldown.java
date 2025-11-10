class Solution {
    public int maxProfit(int arr[]) {
        // Code here
        int n = arr.length;
        if (n == 0) return 0;

        long dp0 = 0;           
        long dp1 = -arr[0];     
        long dp2 = 0;           
        
        for (int i = 1; i < n; ++i) {
            long price = arr[i];
            long prev0 = dp0, prev1 = dp1, prev2 = dp2;
            
            dp0 = Math.max(prev0, prev2);            
            dp1 = Math.max(prev1, prev0 - price);    
            dp2 = prev1 + price;
        }
        
        return (int)Math.max(dp0, dp2);
    }
}
