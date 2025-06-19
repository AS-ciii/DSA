class Solution {
    public static String caseSort(String s) {
        // code here
        int n=s.length();
        ArrayList<Character>u=new ArrayList<>();
        ArrayList<Character>l=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)>='A' && s.charAt(i)<='Z')
            {
                u.add(s.charAt(i));
            }
            else
            {
                l.add(s.charAt(i));
            }
        }
        Collections.sort(u);
        Collections.sort(l);
        int ui=0,li=0;
        // String ans="";
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++)
        {
           if(Character.isUpperCase(s.charAt(i)))
           {
            //   ans+=u.get(ui++);
                ans.append(u.get(ui++));
           }
           else
           {
            //   ans+=l.get(li++);
                ans.append(l.get(li++));
           }
        }
        return ans.toString();
    }
}
