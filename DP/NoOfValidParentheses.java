class Solution {
    int[][]dp;
    int findWays(int n) {
        // code here
        dp=new int[n+1][n+1];
        for(int[]i:dp)Arrays.fill(i,-1);
        return findWays(n,0);
    }
    int findWays(int n,int open){
        if(n<open)return 0;
        if(n==open)return 1;
        if(dp[n][open]!=-1)return dp[n][open];
        int op1=findWays(n-1,open+1);
        int op2=(open>0) ? findWays(n-1,open-1):0;
        return dp[n][open]=op1+op2;
    }
}

