class Solution {
    private boolean check_d(int n, int d)
    {
        int a=n, sum=0;
        while(a>0)
        {
            sum+= a%10;
            a=a/10;
        }
        return (n-sum)>=d;
    }
    public int getCount(int n, int d) 
    {
        int low=1, high=n, limit=0;;
        while(low<=high)
        {
            int mid= (low+high)/2;
            if(check_d(mid,d)) 
            {
                limit=mid;
                high=mid-1; 
            }
            else
                low=mid+1; 
        }
        
        if(limit!=0)
            return n-limit+1; 
        return 0;
    }
};
