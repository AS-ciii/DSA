class Solution {
    public boolean isMaxHeap(int arr[])
    {
    for(int i=arr.length-1;i>=1;i--)
        if(arr[i]>arr[(i-1)/2])
            return false;
    return true;
    }
}
