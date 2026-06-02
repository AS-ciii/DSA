class Solution {
    public int sumDiffPairs(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int n=arr.length;
        if(n<2)
        return 0;
        
        int next=n-1;
        int prev=n-2;
        int ans=0;
        while(prev>=0&&next>=0)
        {
            int diff=arr[next]-arr[prev];
            if(diff>=k)
            {
                next=prev;
                prev--;
            }
            else{
                ans+=arr[next]+arr[prev];
                next=next-2;
                prev=prev-2;
            }
            
        }
        
        return ans;
    }
}

