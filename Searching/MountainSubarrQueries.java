class Solution {
    public ArrayList<Boolean> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] pre = new int[n];
        int[] suff = new int[n];
        
        //Initialise all elements to 1
        for (int i = 0; i < n; i++) {
            pre[i] = 1;
            suff[i] = 1;
        }
        
        // Populate prefix array (non-increasing check)
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] >= arr[i]) {
                pre[i] += pre[i - 1];
            }
        }
        
        // Populate suffix array (non-decreasing check)
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1]) {
                suff[i] += suff[i + 1];
            }
        }
        
        ArrayList<Boolean> res = new ArrayList<>();
        
        // Process each mountain array range query
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            
            if (suff[l] + pre[r] - 1 >= r - l + 1) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        
        return res;
    }
}
