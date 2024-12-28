package Arrays;

class Solution {
    void pushZerosToEnd(int[] arr) {
        int i = 0;
        
        for(int j=0; j<arr.length; j++) {
            if(arr[j]!=0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        
    }    
}
