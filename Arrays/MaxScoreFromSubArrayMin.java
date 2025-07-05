class Solution {
    public int maxSum(int arr[]) {
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++){
            ans=Math.max(ans,arr[i]+arr[i-1]);
        }
        return ans;
    }
}
