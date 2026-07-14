class Solution{
    public boolean isPossible(int[] arr,long mid){
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(mid>=Long.MAX_VALUE/2){
                mid=Long.MAX_VALUE;
            }
            else{
                mid=2*mid-arr[i];
            }
            if(mid<=0){
                return false; 
            }
        }
        return mid>0;
    }
    public int find(int[] arr){
        int n=arr.length;
        long low=0;long high=(long)1e9;
        long ans=high;
        while(low<=high){
            long mid=low+(high-low)/2;
            if(isPossible(arr,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return (int)ans;
    }
}
