 public ArrayList<Integer> optimalArray(int[] arr) {
        // code here
        int n = arr.length;
        long[] prefix = new long[n];
        ArrayList<Integer> ans = new ArrayList<>();

        // Prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i] = arr[i];
            if (i > 0) {
                prefix[i] += prefix[i - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            int k = i / 2;

            long prefI = prefix[i];
            long prefK = prefix[k];

            long left = (long) arr[k] * (k + 1) - prefK;
            long right = (prefI - prefK) - (long) arr[k] * (i - k);

            ans.add((int) (left + right));
        }

        return ans;
    }
}
