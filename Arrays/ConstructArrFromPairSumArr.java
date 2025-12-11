class Solution {
    public ArrayList<Integer> constructArr(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        int m = arr.length;
        if (m == 0) return res; // just in case

        // Find n from m = n * (n - 1) / 2
        long disc = 1L + 8L * m;              // discriminant
        long s = (long) Math.sqrt(disc);
        int n = (int) ((1 + s) / 2);

        // Special case: original array size n = 2
        if (n == 2) {
            res.add(0);           // any value
            res.add(arr[0]);      // so that sum matches arr[0]
            return res;
        }

        // General case: n >= 3
        long s01 = arr[0];        // res0 + res1
        long s02 = arr[1];        // res0 + res2
        long s12 = arr[n - 1];    // res1 + res2 (position of (1,2))

        long r0 = (s01 + s02 - s12) / 2L;  // res[0]

        // Fill original array
        res.add((int) r0);
        for (int i = 1; i < n; i++) {
            long val = (long) arr[i - 1] - r0;  // res[i] = arr[i-1] - res0
            res.add((int) val);
        }

        return res;
    }
}
