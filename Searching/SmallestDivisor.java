class Solution {
    int smallestDivisor(int[] arr, int k) {
        
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            maxi = Math.max(maxi,arr[i]);
        }
         if(n > k) return -1;

        int low = 1;
        int high = maxi;
        
        while(low<=high){
            int mid = (low+high)/2;
            
            int s = totalSum(arr,mid);
            if(s<=k){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    
    public int totalSum(int[] arr, int div){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum+= Math.ceil((double)(arr[i])/(double)(div));
        }
        return sum;
    }
}
