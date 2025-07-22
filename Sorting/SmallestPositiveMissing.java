class Solution {
    public int missingNumber(int[] arr) {
        // code here
        Arrays.sort(arr);
        int pos1=-1, n=arr.length, prev=1;
        for(int x=0; x<n; x++) //we want the position of element 1
        {
            if(arr[x]==1)
            {
                pos1=x; //store the position of element 1
            }
            if(arr[x]>1) //since its sorted if any element is greater than 1 we know 1 cannot be found after it. 
                break;
        }
        if(pos1==-1) // 1 is not present
            return 1;
        if(pos1==n-1) // eg: -1 0 1 1 is the last element of sorted array
            return 2;
        
        for(int x=pos1+1; x<n;x++)
        {
            if(prev+1!=arr[x] && prev!=arr[x]) // checks for repeated elemnt and if the prev element +1 != current element
                return prev+1;
            prev=arr[x];
        }
        return prev+1;
    }
}
