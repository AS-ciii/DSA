class Solution {
    public boolean validgroup(int[] arr, int k) {
        int min = 100001,max=0;
        for(int i:arr)
        {
            if(min>i)min=i;
            if(max<i)max=i;
        }
        if((max-min+1)<k)return false;
        int a[] = new int[max-min+1];
        for(int i:arr)
        a[i-min]++;
        int ans = 0,n=max-min+1;
        int add = 0;
        int t[] = new int[n+1];
        for(int i=0;i<=n-k;i++)
        {
            add+=t[i];
            if(a[i]+add>0)
            {
                add-=a[i];
                t[i+k]+=a[i];
            }
            else if(a[i]+add<0)return false;
        }
        for(int i=n-k+1;i<n;i++)
        if(a[i]+(add+=t[i])!=0)return false;
        return true;
    }
}

