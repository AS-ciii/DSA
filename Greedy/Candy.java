class Solution {
    public int minCandy(int arr[]) {
        int n = arr.length;
        
        int []giveCandy = new int[n];
        Arrays.fill(giveCandy, 1);
        
        for(int i = 1; i < n; i++) {
            if(arr[i] > arr[i - 1]) {
                giveCandy[i] = Math.max(giveCandy[i], giveCandy[i-1] + 1);
            }
            int j = n - i - 1;
            if(arr[j] > arr[j + 1]) {
                giveCandy[j] = Math.max(giveCandy[j], giveCandy[j+1] + 1);
            }
        }
        
        int result = 0;
        
        for(int candy : giveCandy) {
            result += candy;
        }
        return result;
    }
}
