class Solution {
    int solve(int cost[],int w,int idx,int dp[][]){
        if(w==0){
            return 0;
        }
        if(w<0||idx>=cost.length) return Integer.MAX_VALUE;
        
        if(dp[idx][w]!=-1) return dp[idx][w];
        
        int take=Integer.MAX_VALUE;
        
        if(cost[idx]!=-1){
            int result=solve(cost,w-(idx+1),idx,dp);
            if(result!=Integer.MAX_VALUE){
                take=cost[idx]+result;
            }
        }
        
        int notTake=solve(cost,w,idx+1,dp);
        
        return dp[idx][w]=Math.min(take,notTake);
    }
    public int minimumCost(int[] cost, int w) {
        // code here
        int dp[][]=new int[cost.length][w+1];
        
        for(int i=0;i<cost.length;i++){
            Arrays.fill(dp[i],-1);
        }
        
        int result=solve(cost,w,0,dp);
        
        return result!=Integer.MAX_VALUE?result:-1;
    }
}

