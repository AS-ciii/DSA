package Prefix_Sum;

class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int[] res = new int[arr.length];
        
        int total = 1;
        int count = 0;
        
        for(int i : arr) {
            if(i==0) count++;
            else total *= i;
        }
        
        if(count>1) return res;
        
        if(count==1) {
            for(int i=0; i<arr.length; i++) {
                if(arr[i]==0) res[i] = total;
            }
            
            return res;
        }
        
        for(int i=0; i<arr.length; i++) res[i] = total/arr[i];
        
        return res;
    }
}
