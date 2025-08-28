class Solution {
    public int maxOnes(int arr[], int k) {
        // code here
        
        int len = 0 ; 
        int l = 0 ; 
        int r = 0 ; 
        int count = 0 ; 
        while(r<arr.length){
            if(arr[r]==0){
                count++ ; 
            }
            
            if(count<=k){
                len = Math.max(r-l+1,len);
            }
            else{
                while(count>k){
                    if(arr[l]==0){
                        count-- ; 
                    }
                    l++ ; 
                }
            }
            r++ ; 
        }
    return len ;        
    }
}
