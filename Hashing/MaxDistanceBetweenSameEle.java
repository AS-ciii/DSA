package Hashing;

class Solution {
    public int maxDistance(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max =0;
        
        for(int i=0; i<arr.length; i++) {
            if(map.containsKey(arr[i])) {
                int diff = i-map.get(arr[i]);
                max = Math.max(max, diff);
            } else map.put(arr[i], i);
            
        }
        
        return max;
    }
}
