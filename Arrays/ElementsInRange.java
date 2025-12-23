class Solution {
    public int lowerBound(int[] arr , int a){
        int left = 0;
        int right = arr.length - 1;
        
        int index = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(arr[mid] >= a){
                index = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return index;
    }
    public int upperBound(int[] arr , int b){
        int left = 0;
        int right = arr.length - 1;
        
        int index = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(arr[mid] <= b){
                index = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return index;
    }
    public ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
        // code here
        Arrays.sort(arr);
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int[] query : queries){
            int a = query[0];
            int b = query[1];
            
            int lowerIdx = lowerBound(arr , a);
            int upperIdx = upperBound(arr , b);
            if((lowerIdx == -1) || (upperIdx == -1)){
                result.add(0);
                continue;
            }
            int count = upperIdx - lowerIdx + 1;
            result.add(count);
        }
        return result;
    }
}

