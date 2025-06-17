class Solution {
    public int minimumCoins(int[] arr, int k) {
        // code here
        int n=arr.length;
        Arrays.sort(arr);
        int[] subset = new int[n];
        subset[n-1] = arr[n-1];
        
        for(int i =n-2 ; i >= 0 ; i--){
            subset[i] = arr[i] + subset[i+1];
        }
        
        int min = Integer.MAX_VALUE;
        int sum = 0;
        
        for(int i =0; i< n; i++){
            int ind = findUpper(arr , arr[i] + k , i , n-1);
            
            if(ind == -1){
                min = Math.min(min , sum); 
                continue;
            }
            
            int curr = subset[ind] - ((n - ind) *(arr[i]+k));
            curr += sum;
            
            min = Math.min(min , curr);
            sum += arr[i];
        }
        
        return min;
    }
    
    static int findUpper(int[] arr , int target,  int s , int e){
        
        int ans = -1;
        
        while(s <= e){
            int mid = (s+e)/2;
            
            if(arr[mid] > target){
                ans = mid;
                e = mid - 1;
            } else{
                s = mid + 1;
            }   
        }
        
        return ans;
    }
}

