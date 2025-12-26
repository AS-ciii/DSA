class Solution {
    public int kthMissing(int[] arr, int k) {
        // code here
        ArrayList<Integer> list =new ArrayList<>();
        int n=arr.length;
        int last=arr[n-1]; 
        int j=0,i=1;
        while(i<last){
            if(arr[j]!=i){
                list.add(i);
                i++;
            }else{
                i++;j++;
            }
        }
        if(k>list.size()){
            int t=k-list.size();
            return arr[n-1]+t;
        }else if(list.size()==0) return arr[n-1]+k;
        return list.get(k-1);
        
        
    }
}
