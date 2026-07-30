class Solution {
    public int maxSubsetXOR(int[] arr) {
        int N= arr.length;
        if(N == 0) return 0;
       int num = 0;
       while(true){
         int max = Integer.MIN_VALUE;
         for(int i=0;i<N;i++){
             if(max<arr[i]) max=arr[i];
         }
         if(max == 0) return num;
         num = Math.max(num,num^max);
         for(int i=0;i<N;i++){
           arr[i] = Math.min(arr[i],arr[i]^max);
         }
       }
    }
}
