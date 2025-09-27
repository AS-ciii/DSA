class Solution {
    public int kBitFlips(int[] arr, int k) {
        // code here
           
        int n = arr.length;
        int[] flipped = new int[n]; 
        int flip = 0;               
        int operations = 0;

        for (int i = 0; i < n; i++) {
           
            if (i >= k) {
                flip ^= flipped[i - k];
            }
                if ((arr[i] ^ flip) == 0) {
                if (i + k > n) return -1; 
                operations++;
                flip ^= 1;         
                flipped[i] = 1;    
            }
        }
        return operations;
    }
}
