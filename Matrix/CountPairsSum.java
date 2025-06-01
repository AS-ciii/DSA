class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        // code here
         int n=mat1.length;

        int i1=0,j1=0;        int i2=n-1,j2=n-1;

        int ans=0;
        
        while(i1!=n && i2>=0){
            int a=mat1[i1][j1];
            int b=mat2[i2][j2];
            if(a+b==x){
                ans++;
                j1++;j2--;
            }
            else if(a+b<x)
                j1++;
            else
                j2--;
            if(j1==n){
                i1++;j1=0;
            }
            if(j2<0){
                i2--;j2=n-1;
            }
        }
        return ans;
    }
}
