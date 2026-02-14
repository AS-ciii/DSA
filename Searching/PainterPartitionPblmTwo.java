class Solution {
    
    public static boolean itIsEnoughTime(int[] arr, int k, int allartedTime) {                   int count = 0, currentTimeTaken = 0;


        for (int i = 0; i < arr.length; i++) {
           
            if (arr[i] > allartedTime) return false;
            if (currentTimeTaken + arr[i] <= allartedTime) {
                currentTimeTaken += arr[i];
            }else {
                count++;
                currentTimeTaken = arr[i]; // next painter takes charge
            }
        }
        
        if (currentTimeTaken <= allartedTime) count++;
        if (count <= k) return true;
        return false;
    }


    public int minTime(int[] arr, int k) {
        // code here
        
        int sum = 0, ans = 0;
        for (int it : arr) sum += it;
        int low = Arrays.stream(arr).min().getAsInt(), high = sum;
        
        while (low <= high) {
            int mid  = low + (high-low)/2;
            if (itIsEnoughTime(arr, k, mid)) {
                ans = mid;
                high = mid-1;
            }else {
                low = mid+1; // increat the time for painters to paint boards/walls
            }
        }
        return ans;
    }
}
