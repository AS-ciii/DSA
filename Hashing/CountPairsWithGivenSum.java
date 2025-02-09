package Hashing;

class Solution {
    int countPairs(int arr[], int target) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;
        
        for(int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
        
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int ele = entry.getKey();
            int rem = target-ele;
            
            if(ele==rem) {
                int freq = entry.getValue();
                count += (freq*(freq-1))/2;
            } else if(freqMap.containsKey(rem) && ele<rem) {
                count += entry.getValue()*freqMap.get(rem);
            }
        }
        
        return count;
    }
}
