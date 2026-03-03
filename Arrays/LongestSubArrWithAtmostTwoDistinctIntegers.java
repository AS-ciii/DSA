class Solution {
    public int totalElements(int[] arr) {
        // code here
       // Arrays.sort(arr);
         int c=0,j=0;
         
        HashMap<Integer,Integer> mp=new HashMap<>();
        
        for(int i=0;i<arr.length;i++)
        {
              mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
              if(mp.size()>2)
              {
                  mp.put(arr[j],mp.get(arr[j])-1);
                   if(mp.get(arr[j])==0)
                   {
                       mp.remove(arr[j]);
                   }
                   j++;
              }
            //   c=Math.max(c,(i-j+1));
            c=Math.max(c,i-j+1);
        }
        
        return c;
    }
}
