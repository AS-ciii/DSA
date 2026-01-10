class Solution {
    public int atMost(String s, int k) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, cnt = 0;
        int n = s.length();

        while (l < n) {
            map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) + 1);

            while (map.size() > k) {
                map.put(s.charAt(r), map.get(s.charAt(r)) - 1);
                if (map.get(s.charAt(r)) == 0)
                    map.remove(s.charAt(r));
                r++;
            }

            cnt += l - r + 1;
            l++;
        }
        return cnt;
    }
    public int countSubstr(String s, int k){
        return atMost(s,k)- atMost(s,k-1);
    }
    
}
