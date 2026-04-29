class Solution {
    public int minSwaps(int[] arr) {
        // code here
        int c = 0, n = arr.length;
        for(int i:arr) {
            if(i == 1) c+=1;
        }
        
        if(c == 0) return -1;
        
        int max = n, cc = 0;
        for(int i=0;i<c;i++) {
            if(arr[i] == 1) cc+=1;
        }
        
        max = Math.min(max, c-cc);
        for(int i=c;i<n;i++) {
            if(arr[i-c] == 1) cc-=1;
            if(arr[i] == 1) cc+=1;
            max = Math.min(max, c-cc);
        }
        
        return max;
    }
}
