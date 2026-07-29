class Solution {
    int minSubsets(int arr[]) {
        Arrays.sort(arr);
        int c=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1]+1)
             continue;
            else 
             c++;
        }
        return c+1;
    }
}
