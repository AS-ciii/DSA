class Solution {
    public boolean kSubstr(String s, int k) {
        // code here
        int n = s.length();
        if(n % k != 0) return false;
        
        HashMap<String , Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < n ; i += k){
            String subStr = s.substring(i , i + k);
            map.put(subStr , map.getOrDefault(subStr , 0) + 1);
            if(map.size() >= 3){
                return false;
            }
        }
        int cnt = 0;
        for(String str : map.keySet()){
            if(map.get(str) >= 2){
                cnt++;
            }
        }
        
        return cnt < 2 ;
    }
}

