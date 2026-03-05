class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer>map = new HashMap<>();
        int ans=-1;
        int j=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
            while(map.size()>k)
            {
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)-1);
                if(map.get(s.charAt(j))==0)
                map.remove(s.charAt(j));
                j++;
            }
            if(map.size()==k)
            {
                ans=Math.max(ans,i-j+1);
            }
        }
        
        return ans;
    }
}
