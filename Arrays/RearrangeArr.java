class Solution {
    boolean isSorted(int arr[])
    {
        int len=arr.length;
        for(int i=0;i<len-1;i++)
        {
            if(arr[i+1]!=arr[i]+1)
            return false;
        }
        return true;
    }
    int minOperations(int[] b) {
        // code here
        int len=b.length;
        int count=0;
        int arr[]=new int[len];
        for(int i=0;i<len;i++)
        arr[i]=i+1;
        
        do
        {
            int next[]=new int[len];
            for(int i=0;i<len;i++)
            next[b[i]-1] = arr[i];
            
            arr=next;
            count++;
        }
        while(!isSorted(arr));
        return count;
    }
};
