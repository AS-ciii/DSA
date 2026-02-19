class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
 

        
       Set<Integer> set=new HashSet<>();
       for(int num:arr)
       {
           set.add(num);
       }
       ArrayList<Integer> ans=new ArrayList<>();
       for(int i=low;i<=high;i++)
       {
           if(!set.contains(i))
            ans.add(i);
       }
       return ans;
      
    }
}
