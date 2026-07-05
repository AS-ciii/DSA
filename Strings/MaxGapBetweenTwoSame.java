class Solution {
    public int maxCharGap(String s) {
        int n = s.length(), mx = -1;
        int[] freq = new int[26];
        Arrays.fill(freq,-1);
        
        for(int i=0; i<n; i++) {
            int prev = freq[s.charAt(i)-'a'];
            
            if(prev == -1)  freq[s.charAt(i)-'a'] = i;
            if(prev != -1)  mx = Math.max(mx, i - prev - 1);
        }
        
        return mx;
    }
};
