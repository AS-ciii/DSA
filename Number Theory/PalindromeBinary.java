class Solution {
    public boolean isBinaryPalindrome(int n) {
        // code here
        int temp = n;
        int num = 0;
        while(n!=0){
            int bit = n&1;
            num <<= 1;
            num |= bit;
            n >>= 1;
        }
        return temp == num;
    }
};
