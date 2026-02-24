class Solution {
    int equalSumSpan(int[] a1, int[] a2) {
        int n = a1.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int prefixSum = 0;
        int maxLen = 0;
        
        for(int i = 0; i < n; i++) {
            prefixSum += (a1[i] - a2[i]);
            
            // If prefix sum becomes 0
            if(prefixSum == 0) {
                maxLen = i + 1;
            }
            
            // If seen before
            if(map.containsKey(prefixSum)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum));
            } else {
                map.put(prefixSum, i);
            }
        }
        
        return maxLen;
    }
}

