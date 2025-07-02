class Solution {
    public int totalElements(int[] arr) {
        // code here
        int n=arr.length;
        int i=-1;
        int j=-1;
        int k=0;
        int ans=1;
        while(k<n)
        {
            if(i==-1)
            {
                i=k;
                k++;
            }
            else
            if(arr[k]==arr[i])
            {
                 k++;   
            }
            else
            if(j==-1)
            {
                j=k;
                k++;
            }
            else
            if(arr[k]==arr[j])
            {
                k++;
            }
            else
            {
              // System.out.println(i+" "+j);
                ans=Math.max(ans,k-i);
                k=j;
                i=-1;
                j=-1;
            }
        }
      // System.out.println(i+" "+j);
        ans=Math.max(ans,k-i);
        return ans;
    }
}

