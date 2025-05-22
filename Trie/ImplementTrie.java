class Solution {
    static int minDeletions(String s) {
        // code here
        int n=s.length();
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        int[][] dp=new int[n][n];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return n-lcs(n-1,n-1,s,sb.toString(),dp);
    }
    static int lcs(int ind1,int ind2,String str,String revStr,int[][] dp){
        if(ind1<0 || ind2<0) return 0;
        if(dp[ind1][ind2]!=-1)
            return dp[ind1][ind2];
        if(str.charAt(ind1)==revStr.charAt(ind2)){
            return dp[ind1][ind2]=1+lcs(ind1-1,ind2-1,str,revStr,dp);
        }
        int val1=lcs(ind1-1,ind2,str,revStr,dp);
        int val2=lcs(ind1,ind2-1,str,revStr,dp);
        return dp[ind1][ind2]=Math.max(val1,val2);
    }
}
