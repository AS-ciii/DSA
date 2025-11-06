class Solution {
    public static int find_ways(int c_l,int n,int [] dp)
    {   if(dp[c_l] != -1)
        return dp[c_l];
        
        if(c_l == n)
        return 1;
        
 
        int hori = 0;
        int ver = 0;
        if(c_l + 1 <= n)
        hori = find_ways(c_l + 1,n,dp);
        if(c_l + 2 <= n)
        ver = find_ways(c_l + 2,n,dp);
        
        dp[c_l] =  hori + ver;
        return dp[c_l];
    }
    public int numberOfWays(int n) {
        // code here
        int [] dp = new int [n + 1];
        Arrays.fill(dp,-1);
        return find_ways(0,n,dp);
    }
};
