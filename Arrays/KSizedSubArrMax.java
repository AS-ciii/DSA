class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        int max=0;
        ArrayList<Integer> list=new ArrayList<>();   
        for(int i=0;i<k;i++)
        {
            if(max<arr[i])
                max=arr[i];
        }
        list.add(max);
        int len=k;
        for(int i=0;i<arr.length-len;i++)
        {
            if(arr[i]==max)
            {
                max=0;
                for(int j=i+1;j<=k;j++)
                {
                    if(max<arr[j])
                        max=arr[j];
                }
            }
            if(arr[k]>max)
                max=arr[k];
            list.add(max);
            k++;
        }
        return list;
    }
}
