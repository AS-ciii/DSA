class Solution {

    public int maxChocolate(int grid[][]) {

        int n=grid.length,m=grid[0].length;

        int[][]dp=new int[m][m];

        for(int j1=0;j1<m;j1++)

        for(int j2=0;j2<m;j2++){

            if(j1==j2)

            dp[j1][j2]=grid[n-1][j1];

            else

            dp[j1][j2]=grid[n-1][j1]+grid[n-1][j2];

        }

       for(int i=n-2;i>=0;i--){

           int[][]cur=new int[m][m];

           for(int j1=0;j1<m;j1++){

               for(int j2=0;j2<m;j2++){

                   int max=-1;

                   for(int d1=-1;d1<=1;d1++)

                       for(int d2=-1;d2<=1;d2++){

                           int nj1=j1+d1,nj2=j2+d2;

                           if(nj1>=0&&nj1<m&&nj2>=0&&nj2<m)

                               max=Math.max(max,dp[nj1][nj2]);

                       

                   }

                   int curChoco=(j1==j2)?grid[i][j1]:grid[i][j1]+grid[i][j2];

                   cur[j1][j2]=curChoco+max;

               }

           }

           dp=cur;

       }

       return dp[0][m-1];

    }

}
