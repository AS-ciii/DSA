class Solution {
    public int optimalKeys(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return func(n,dp);
    }
    private int func(int n,int[] dp){
        if(n<=0) return 0;
        
        if(dp[n]!=-1) return dp[n];
        int addA=func(n-1,dp)+1;
        
        for(int j=1;j<=n-3;j++){
            int current=func(j,dp)*func(n-j-1,dp);
            
            addA=Math.max(addA,current);
        }
        return dp[n]= addA;
    }
}
