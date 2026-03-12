class Solution {
    public int kBitFlips(int[] arr, int k) {
        // code here
        Queue<Integer> qu= new LinkedList<>();
        int n=arr.length;
        int f=0;
        for(int i=0;i<n;i++){
            if(!qu.isEmpty() && qu.peek()+k==i){
                qu.poll();
            }
            int cr=arr[i];
            if(qu.size()%2!=0){
                cr^=1;
            }
            if(cr==0){
                if(i+k>n){
                    return -1;
                }
                qu.offer(i);
                f++;
            }
        }
        return f;
    }
}
