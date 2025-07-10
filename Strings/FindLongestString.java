class Solution {
    public String longestString(String[] words) {
        // code here
        
         Arrays.sort(words); 
        Set<String> st=new HashSet<>();
        String ans="";
        
        for(String word:words)
        {
            if(word.length()==1 || st.contains(word.substring(0,word.length()-1)))
            {
                st.add(word);
                
                if(word.length()>ans.length() ||
               word.length()==ans.length() && word.compareTo(ans)<0)
                {
                    ans=word;
                }
            }
            
        }
        
        return ans;
    }
    

}
