class Solution {
     public static int findans(int[] arr, int ind, int[] dp) {
        if (ind == arr.length - 1) return 0;
        if (dp[ind] != -1) return dp[ind];
        
        int ans1 = Math.abs(arr[ind] - arr[ind + 1]) + findans(arr, ind + 1, dp);
        int ans2 = Integer.MAX_VALUE;
        if (ind + 2 < arr.length)
            ans2 = Math.abs(arr[ind] - arr[ind + 2]) + findans(arr, ind + 2, dp);
        
        return dp[ind] = Math.min(ans1, ans2);
    }
    int minCost(int[] height) {
        int [] mat =new int[height.length + 1];
        Arrays.fill(mat,-1);
        int res = findans(height,0,mat);
        return res;
        
    }
}
