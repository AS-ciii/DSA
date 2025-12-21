
Rakesh Mehta
53 minutes agoDec 21, 2025 22:24 (GMT +5:30)

class Solution {
    public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
        // code here
        //our case is the find the index of first occurence and last occurence of the given element
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<queries.length;i++)
        {
            int low=queries[i][0];
            int high=queries[i][1];
            int x=queries[i][2];
            int firstOccurence = binarySearchFirstOccurence(arr,low,high,x);
            int last = binarySearchForLastOccurence(arr,low,high,x);
            if(firstOccurence==-1&&last==-1)
            {
              ans.add(0);   
            }
            else if(firstOccurence==last)
            {
              ans.add(1);  
            }
            else{
              ans.add(last-firstOccurence+1);  
            }
        }
        return ans;
    }
    public int binarySearchFirstOccurence(int[]arr,int low,int high,int x)
    {
        //this is an element search problem 
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            if(arr[mid]==x)
            {
               ans=mid;
               high=mid-1;
            }
            else if(arr[mid]<x)
            {
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
       public int binarySearchForLastOccurence(int[]arr,int low,int high,int x)
    {
        //this is an element search problem 
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            if(arr[mid]==x)
            {
               ans=mid;
               low=mid+1;
            }
            else if(arr[mid]<x)
            {
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}

