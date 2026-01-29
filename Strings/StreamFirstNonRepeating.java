class Solution {
    public String firstNonRepeating(String s) {
        // code here
        int n=s.length();
        if(n==0)
        return "";
        
        HashMap<Character,Integer>set = new HashMap<>();
        Queue<Character>q= new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        
    
        for(int i=0;i<n;i++)
        {
           char ch=s.charAt(i);
           set.put(ch,set.getOrDefault(ch,0)+1); 
           q.add(ch);
           
           while(!q.isEmpty()&&set.get(q.peek())>1)
           {
               q.poll();
           }
           if(q.isEmpty())
           {
               ans.append('#');
           }
           else{
               ans.append(q.peek());
           }
        }
        return ans.toString();
    }
}
