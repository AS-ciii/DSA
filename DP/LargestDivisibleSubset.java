class Solution {
    public int lds(int[] arr, int[] memo, int[] parent, int i) {
        if (memo[i] != -1) {
            return memo[i];
        }

        int maxLength = 1;
        int bestParent = -1;

        for (int j = 0; j < i; j++) {
            if (arr[j] % arr[i] == 0) {
                int length = lds(arr, memo, parent, j) + 1;
                if (length > maxLength) {
                    maxLength = length;
                    bestParent = j;
                }
            }
        }

        memo[i] = maxLength;
        parent[i] = bestParent;
        return maxLength;
    }

    public ArrayList<Integer> largestSubset(int[] arr) {
        int n = arr.length;

        // Sort in descending order using Arrays.sort + reverse
        Integer[] temp = new Integer[n];
        for (int i = 0; i < n; i++) temp[i] = arr[i];
        Arrays.sort(temp, Collections.reverseOrder());
        for (int i = 0; i < n; i++) arr[i] = temp[i];

        int[] memo = new int[n];
        int[] parent = new int[n];
        Arrays.fill(memo, -1);
        Arrays.fill(parent, -1);

        int maxSize = 0;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {
            int size = lds(arr, memo, parent, i);
            if (size > maxSize) {
                maxSize = size;
                lastIndex = i;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = lastIndex; i >= 0; i = parent[i]) {
            result.add(arr[i]);
            if (parent[i] == -1) break;
        }

        return result;
    }
}
