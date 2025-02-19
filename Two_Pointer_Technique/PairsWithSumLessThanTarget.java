package Two_Pointer_Technique;

class Solution {
    int countPairs(int arr[], int target) {
        int count = 0;
        int i = 0;
        int j = arr.length-1;
        
        Arrays.sort(arr);
        
        while(i<j) {
            int sum = arr[i]+arr[j];
            
            if(sum<target) {
                count += j-i;
                i++;
            } else j--;
        }
        
        return count;
    }
}
