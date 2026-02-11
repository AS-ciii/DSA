class Solution {
    public int minCost(int[] heights, int[] cost) {
        // code here
        int max=heights[0];
        int min=heights[0];
        for(int i=0;i<heights.length;i++)
        {
            max=Math.max(max,heights[i]);
            min=Math.min(min,heights[i]);
        }
        int ans=Integer.MAX_VALUE;
        while(min<=max)
        {
            int mid=min+(max-min)/2;
            
            int currCost1=totalCost(heights,cost,mid-1);
            int currCost2=totalCost(heights,cost,mid);
            int currCost3=totalCost(heights,cost,mid+1);
            if(currCost2<=currCost1&&currCost2<=currCost3)
            return currCost2;
            
            if(currCost1>=currCost2&&currCost2>=currCost3)
            {
                min=mid+1;
            }
            else{
                max=mid-1;
            }
        }
        return ans;
    }
    public int totalCost(int []arr,int[]cost,int h)
    {
        int currCost=0;
        for(int i=0;i<arr.length;i++)
        {
            int diff=Math.abs(arr[i]-h);
            currCost+=diff*cost[i];
        }
        return currCost;
    }
}
