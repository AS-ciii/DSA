class Solution {
    public int[] singleNum(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        int[] res = new int[2];
        int index = 0;
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()==1) res[index++] = entry.getKey();
        }
        
        Arrays.sort(res);
        
        return res;
    }
}
