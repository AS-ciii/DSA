class Solution {
    
    Integer[][] dp;
    public int solve(int idx , int[] freq , int n){
        if(idx == n){
            return 1;
        }
        // Create a mask from freq array to use as memoization key
        int mask = 0;
        for (int i = 0; i < n; i++) {
            if (freq[i] > 0) {
                mask |= (1 << i);
            }
        }
        if (dp[idx][mask] != null) {
            return dp[idx][mask];
        }
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            if(i != idx && freq[i] > 0){
                freq[i]--;
                ans = ans + solve(idx + 1 , freq , n);
                freq[i]++;
            }
        }
        return dp[idx][mask] = ans;
    }
    public int derangeCount(int n) {
        // code here
        dp = new Integer[n][1 << n];
        int[] freq = new int[12];
        Arrays.fill(freq , 1);
        return solve(0 , freq , n);
        
    }
}
