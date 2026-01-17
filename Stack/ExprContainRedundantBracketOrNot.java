class Solution {
    public static boolean checkRedundancy(String s) 
    {
        // code here
        Stack<Character> st= new Stack<>();
        
        for(int x=0; x<s.length(); x++)
        {
            char ch= s.charAt(x);
            if(ch==')')
            {
                if(st.peek()=='(')
                    return true;
                char p= st.pop();
                while(!st.isEmpty() && p!='(')
                {
                    p=st.pop();
                }
            }
            else if(!Character.isLetter(ch))
                st.push(ch);
        }
        return false;
    }
}
