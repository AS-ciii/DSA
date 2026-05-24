class Solution {
    public int coin(int[] arr) {
        // code here
        int n = arr.length;
        int i = 0;
        int j = arr.length-1;
        
        while(i<=j){
             if(i == j){
                  return arr[i];  
                }
                
            if(arr[i]>arr[j]){
                i++;
            }else if(arr[i]==arr[j]){
               
                i++;
            }else{
                j--;
            }
        }
        return arr[i-1];
    }
}
