class Solution {
    public static int longestSubarray(int[] arr) {
        return isSub(arr,0,arr.length);
    }
    public static int isSub(int arr[],int start,int end) {

    if(start>=end) return 0;
    int i;

    for(i=start;i<end;i++) {

       if(arr[i]>end-start)break;
    }
    if(i==end)return end-start;
    int max=Math.max(isSub(arr,start,i),isSub(arr,i+1,end));

    return max;
    }
}
