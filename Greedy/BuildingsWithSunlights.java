class Solution {
    public int visibleBuildings(int arr[]) {
        // code here
        int maxHeight=Integer.MIN_VALUE, count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=maxHeight){
                maxHeight=arr[i];
                count++;
            }
        }
        return count;
    }
}
