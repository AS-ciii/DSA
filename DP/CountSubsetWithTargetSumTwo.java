class Solution {
    private HashMap<String, Integer> dp;

    public int countSubset(int[] arr, int k) {
        int psum = 0, nsum = 0;
        for (int num : arr) {
            if (num > 0) psum += num;
            else nsum += num;
        }
        if (k > psum || k < nsum) return 0;

        dp = new HashMap<>();
        return solve(0, arr, k);
    }

    private int solve(int i, int[] arr, int k) {
        if (i == arr.length) return k == 0 ? 1 : 0;

        String key = i + "_" + k;
        if (dp.containsKey(key)) return dp.get(key);

        int inc = solve(i + 1, arr, k - arr[i]);
        int exc = solve(i + 1, arr, k);

        dp.put(key, inc + exc);
        return inc + exc;
    }
}
