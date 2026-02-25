class Solution {
    public int longestSubarray(int[] arr, int k) {
        // Code Here
       HashMap<Integer,Integer> map = new HashMap<>();
       
       int maxLen = 0;
       int n = arr.length;
       int gtk = 0; //count of greater than k elements
       int lek = 0; // count of less or equal to k elements
       
       int j = 0;
       
       while(j < n){
           if(arr[j] > k) gtk++;
           else  lek++;
           
           int  diff = gtk - lek;
           //checking for (diff - 1) beacuse you are //assuming that another lek element could occur in //previous window
           if((diff - 1) < 0 && map.containsKey(diff - 1)){
               maxLen = Math.max(maxLen , (j - (map.get(diff - 1))));
           }else{
               if((diff - 1) >= 0){
                   maxLen = Math.max(maxLen , j + 1);
               }
           }
           if(!map.containsKey(diff)){
               map.put(diff , j);
           }
           j++;
        }
        return maxLen;
    }
}

