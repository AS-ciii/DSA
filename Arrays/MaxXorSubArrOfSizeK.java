class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        int i=0;
        int sum=0,j;
        for(j=0;j<k;j++){
            sum=sum^arr[j];
        }
        j=i+k;
        int max=sum;
        while(j<arr.length){
            sum=sum^arr[i];
            i++;
            sum=sum^arr[j];
            if(sum>max){
                max=sum;
            }
            j++;
        }
        return max;   
    }
}
