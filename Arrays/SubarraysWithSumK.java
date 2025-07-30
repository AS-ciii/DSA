class Solution {
    public int cntSubarrays(int[] arr, int k) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        
        int count = 0;
        int prefixSum = 0;
        prefixSumMap.put(0, 1);

        for (int num : arr) {
            prefixSum += num;
            if (prefixSumMap.containsKey(prefixSum - k)) {
                count += prefixSumMap.get(prefixSum - k);
            }
            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}

