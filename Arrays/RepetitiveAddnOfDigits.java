package Arrays;

class Solution {
    public int singleDigit(int n) {
        while(n>=10) {
            int sum = 0;
            while(n>0) {
                sum += n%10;
                n /= 10;
            }
            n = sum;
        }
        return n;
    }
}
