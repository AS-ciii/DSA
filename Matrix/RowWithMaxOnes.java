class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int[] sum=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                sum[i]+=arr[i][j];
            }
            
        }
        int max=0;
        int i=1;
        for(i=1;i<sum.length;i++){
            if(sum[max]<sum[i])max=i;
        }
        return max;
    }
}
