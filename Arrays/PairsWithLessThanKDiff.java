class Solution {
    public static int countPairs(int arr[], int k) {
        // code here
        
        int n = arr.length;
        
        Arrays.sort(arr);
        int pairWithGtEqKdiff = 0;
        
        int i = 0;
        int j = 0;
        while(j < n){
            while(j < n && (arr[j] - arr[i]) < k){
                j++;
            }
            if(j < n && (arr[j] - arr[i]) >= k){
                pairWithGtEqKdiff += (n - j);
            }
            i++;
        }
        int temp = n - 1;
        int totalPair = (temp * (temp + 1)) / 2;
        
        return totalPair - pairWithGtEqKdiff;
    }
}

