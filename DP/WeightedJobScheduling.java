class Solution {
   public int maxProfit(int[][] jobs) {
        // code here
        int n = jobs.length;
    
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));
        
       
        int[] dp = new int[n];
        dp[0] = jobs[0][2];  
        
    
        for (int i = 1; i < n; i++) {
            int profit = jobs[i][2];
            
            int last = findLastNonOverlap(jobs, i);
            if (last != -1)
                profit += dp[last];
            
            dp[i] = Math.max(profit, dp[i - 1]);
        }
        
        return dp[n - 1];
    }


    private int findLastNonOverlap(int[][] jobs, int i) {
        int low = 0, high = i - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs[mid][1] <= jobs[i][0]) {
                if (mid + 1 <= high && jobs[mid + 1][1] <= jobs[i][0])
                    low = mid + 1;
                else
                    return mid;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
