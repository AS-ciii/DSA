class Solution {
    
    public int binarySearch(int[] arr , int left , int right , int x){
        int index = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(arr[mid] <= x){
                index = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return index;
    }
    
    public int getPivot(int[] arr){
        int n = arr.length;
        if(arr.length >= 2){
            if(arr[0] > arr[1]) return 0;
            if(arr[n - 2] > arr[n - 1])return n - 2;
        }
        int left = 1;
        int right = n - 2;
        int index = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if((arr[mid - 1] < arr[mid]) && (arr[mid] > arr[mid + 1])){
                index = mid;
            }
            if(arr[mid] < arr[right]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return index;
    }
    public int countLessEqual(int[] arr, int x) {
        // code here
        int n = arr.length;
        if(n == 1){
            return (arr[0] <= x) ? 1 : 0 ;
        }
        int pivotIdx = getPivot(arr);
        
        if(pivotIdx == -1){
            int lastIdx = binarySearch(arr , 0 , arr.length - 1 , x);
            return (lastIdx == -1) ? 0 : lastIdx + 1;
        }
        
        int leftIdx = binarySearch(arr , 0 , pivotIdx , x);
        int leftCount = (leftIdx == -1) ? 0 : leftIdx + 1;
        
        int rightIdx = binarySearch(arr , pivotIdx + 1 , n - 1 , x);
        int rightCount = (rightIdx == -1) ? 0 : rightIdx - (pivotIdx + 1) + 1;
        
        return (leftCount + rightCount);
    }
}
