class Solution {
    public int findPosition(int n) 
    {
       int bit_count=0;
        int i=0,pos=0;
        while(n!=0)
       {
        int bit=n&1;
        if(bit==1)
        {
          bit_count+=1;
          pos=i;
        }
        n=n>>1;
        i++;
    }
       if(bit_count>1 || bit_count==0)
         return -1;
       else
         return pos+1;
    }
}

