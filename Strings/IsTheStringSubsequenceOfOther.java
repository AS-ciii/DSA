class Solution {
    public boolean isSubSeq(String s1, String s2) {
        // code here
        int i = 0 , j = 0;
        int m = s1.length() , n = s2.length();
        while(i<m && j<n)
        {
            if(s1.charAt(i)==s2.charAt(j))
            {
                i++;
                j++;
            }
            else
            j++;
            
            if(i==m)
            break;
        }
        
        if(i==m)
        return true;
        else
        return false;
    }
};
