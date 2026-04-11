class Solution {
    public int countIncreasing(int[] arr) {
        // code here
        int totalCount=0,currentCount=0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]<arr[i+1]){
                currentCount++;
            }else{
                currentCount=0;
            }
            totalCount+=currentCount;
        }
        return totalCount;
    }
}
