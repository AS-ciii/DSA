class Solution {
    String removeSpaces(String s) {
        // code here
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<s.length();i++)
        { 
            char c=s.charAt(i);
            if((c>='a'&&c<='z')||(c>='A'&&c<='Z'))
            ans.append(c);
        }
        
        return ans.toString();
    }
}

