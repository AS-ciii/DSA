package Two_Pointer_Technique;

class Solution {

    public int maxWater(int arr[]) {
        int max = 0;
        
        int i = 0;
        int j = arr.length-1;
        
        while(i<j) {
            int diff = j-i;
            
            if(arr[i]<arr[j]) {
                int k = diff*arr[i];
                if(k>max) max = k;
                i++;
            } else {
                int k = diff*arr[j];
                if(k>max) max = k;
                j--;
            }
        }
        
        return max;
    }
}
