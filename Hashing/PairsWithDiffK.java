package Hashing;

class Solution {
    int countPairs(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int i : arr) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        for(int i : map.keySet()) {
            if(map.containsKey(i-k)) {
                count += map.get(i)*map.get(i-k);
            }
            
            if(map.containsKey(i+k)) {
                count += map.get(i)*map.get(i+k);
            }
        }
        
        return count/2;
    }
}
