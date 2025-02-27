package Prefix_Sum;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = 0;
        int sum = 0;
        
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            
            if(sum==k) len = Math.max(len, i+1);
            
            if(map.containsKey(sum-k)) len = Math.max(len, i-map.get(sum-k));
            
            if(!map.containsKey(sum)) map.put(sum, i);
        }
        
        return len;
    }
}
