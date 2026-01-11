class Solution {
    public String minWindow(String s1, String s2) {
        // code here
        String smallest=s1+'*';
        int n=s1.length();
        int m=s2.length();
        
        for(int i=0;i<n;i++)
        {
            int p1=i;
            int p2=0;
            
            while(p1<n && p2<m)
            {
                if(s1.charAt(p1)==s2.charAt(p2))
                {
                    p1++;
                    p2++;
                }
                else p1++;
            }
            
            if(p2==m)
            {
                
                
                if(p1-i<smallest.length())
                {
                    smallest=s1.substring(i,p1);
                }
            }
        }
        if(smallest.equals(s1+'*'))return "";
        return smallest;
    }
}
