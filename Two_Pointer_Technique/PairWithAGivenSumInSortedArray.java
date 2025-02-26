package Two_Pointer_Technique;

class Solution {

    int countPairs(int arr[], int target) {
        int count = 0;
        int i = 0;
        int j = arr.length-1;
        
        while(i<j) {
            int sum = arr[i]+arr[j];
            
            if(sum==target) {
                
                if(arr[i]==arr[j]) {
                    count += ((j-i+1)*(j-i))/2;
                    break;
                }
                
                int leftCount = 1;
                int rightCount = 1;
                
                while(i+1<j && arr[i]==arr[i+1]) {
                    leftCount++;
                    i++;
                }
                
                while(j-1>i && arr[j]==arr[j-1]) {
                    rightCount++;
                    j--;
                }
                
                count += leftCount*rightCount;
                
                i++; j--;
            }else if(sum>target) j--;
            else i++;
        }
        
        return count;
    }
}