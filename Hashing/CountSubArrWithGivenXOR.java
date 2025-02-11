package Hashing;

class Solution {
    public long subarrayXor(int arr[], int k) {
        long count = 0;
        long xor = 0;
        HashMap<Long, Long> map = new HashMap<>();
        
        map.put(0L, 1L);
        
        for(int i=0; i<arr.length; i++) {
            xor ^= arr[i];
            
            if(map.containsKey(xor^k)) {
                count += map.get(xor^k);
            }
            
            map.put(xor, map.getOrDefault(xor, 0L)+1L);
        }
        
        return count;
    }
}
