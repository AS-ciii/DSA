package Prefix_Sum;

class Solution {
    public int maxLen(int[] arr) {
        int len = 0;
        int ones = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==1) ones++;
            else ones--;
            
            if(map.containsKey(ones)) len = Math.max(len, i-map.get(ones));
            else map.put(ones, i);
        }
        
        return len;
    }
}
