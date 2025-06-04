class Solution {
    int lcsOf3(String s1, String s2, String s3) {
        int n=s1.length();
        int m=s2.length();
        int o=s3.length();
        int dp[][][]=new int[n+1][m+1][o+1];
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                for(int k=1;k<=o;k++){
                        if(s1.charAt(i-1)==s2.charAt(j-1) && s2.charAt(j-1)==s3.charAt(k-1)){
                            dp[i][j][k]=1+dp[i-1][j-1][k-1];
                        }else {
                            dp[i][j][k]= Math.max( Math.max(dp[i-1][j][k],dp[i][j-1][k]), dp[i][j][k-1]) ; 
                        }
                }
            }
        }
        return dp[n][m][o];
    }
}
