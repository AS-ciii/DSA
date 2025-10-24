class Solution {

    public boolean isPossible(int[] arr, int k) {
        // Code here
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Use another HashMap to track the number of subsequences ending at a particular number
        Map<Integer, Integer> endWith = new HashMap<>();

        for (int num : arr) {
            if (count.get(num) == 0) {
                continue;
            }

            // Try to extend an existing subsequence
            if (endWith.getOrDefault(num - 1, 0) > 0) {
                endWith.put(num - 1, endWith.get(num - 1) - 1);
                endWith.put(num, endWith.getOrDefault(num, 0) + 1);
                count.put(num, count.get(num) - 1);
            } 
            // Try to start a new subsequence
            else {
                boolean canStartNew = true;
                for (int i = 1; i < k; i++) {
                    if (count.getOrDefault(num + i, 0) == 0) {
                        canStartNew = false;
                        break;
                    }
                }

                if (canStartNew) {
                    for (int i = 1; i < k; i++) {
                        count.put(num + i, count.get(num + i) - 1);
                    }
                    count.put(num, count.get(num) - 1);
                    endWith.put(num + k - 1, endWith.getOrDefault(num + k - 1, 0) + 1);
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
