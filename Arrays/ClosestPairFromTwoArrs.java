class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int tar)
    {
        // code here
        int l1= arr1.length, l2= arr2.length;
        int x=0, y=l2-1,a=0,b=0;
        int currdiff=Integer.MAX_VALUE, diff=Integer.MAX_VALUE;
        ArrayList<Integer> ans= new ArrayList<>();
        while(x<l1 && y>=0)
        {
            int sum= arr1[x] + arr2[y];
            currdiff= Math.abs(sum-tar);
            
            if(currdiff<diff)
            {
                a=arr1[x]; b=arr2[y];
                diff=currdiff;
            }
            
            if(tar==sum)
            {
                a=arr1[x]; b=arr2[y];
                break;
            }
            
            if(tar<sum)
                y--;
            else
                x++;
            
                
        }
        
        ans.add(a); ans.add(b);
        return ans;
    }
}
