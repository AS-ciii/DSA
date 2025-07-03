class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> h = new HashMap<Character,Integer>();
        
        int l = 0, ans =0;
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            char ch = s.charAt(i);
            
            h.put(ch,h.getOrDefault(ch,0)+1);
            
            while(h.size() > k)
            {
                char ch1 = s.charAt(l);
                h.put(ch1,h.get(ch1)-1);
                if(h.get(ch1) == 0)
                {
                    h.remove(ch1);
                }
                l++;
            }
            ans = Math.max(ans,i-l+1);
        }
        
        if(h.size() < k)  return -1;
        return ans;
        
    }
}
