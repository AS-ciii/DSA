class Solution {
    public int countSubarray(int[] arr, int l, int r) {
    
        int res1=getSubArray(arr,r);
        int res2=getSubArray(arr,l-1);
        return res1-res2;
    
    }
    
    public int getSubArray(int arr[],int x){
        int sum=0;
        int count=0;
        int j=0;
        for (int i = 0; i < arr.length; i++){
            sum=sum+arr[i];
            while(sum>x){
                sum=sum-arr[j];
                j++;
            }
            count+=(i-j+1);
        }
          return count;
    }
}
