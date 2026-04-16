class Solution {
    public int myAtoi(String in) {
        // code here
        String s= in.replaceAll(" ","");
        
        int n=s.length();
        
        if(n==0)
        return 0;
        
        if(n==1&&(s.charAt(0)=='-'||s.charAt(0)=='+'))
        return 0;
        
        int maxMin=-2147483648;
        int maxMax= 2147483647;
        long ans=0;
        if(s.charAt(0)=='-')
        {
           for(int i=1;i<n;i++)
           {
               int c=s.charAt(i)-'0';
               if((c<0||c>9))
               return (int)ans*-1;
               
               ans=ans*10+(s.charAt(i)-'0');
               
               if(ans>maxMax)
               return maxMin;
           }
           ans=ans*-1;
           
           return (int) ans;
        }
        else{
            if(s.charAt(0)=='+')
            {
             for(int i=1;i<n;i++)
           {
               
                int c=s.charAt(i)-'0';
               if((c<0||c>9))
               return (int)ans;
  ans=ans*10+(s.charAt(i)-'0');               
               if(ans>=maxMax)
               return maxMax;
           }
           
           return (int)ans;
            }
            else{
               for(int i=0;i<n;i++)
           {
               
                int c=s.charAt(i)-'0';
               if((c<0||c>9))
               return (int)ans;
  ans=ans*10+(s.charAt(i)-'0');               
               if(ans>=maxMax)
               return maxMax;
           }
           
           return (int)ans;   
            }
        }
  
    }
}

