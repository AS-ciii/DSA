class Solution {
    public static int countSetBits(int n) {
        // code here
        int sum  = 0;
        for(int i = 0; i < 32; i++) {
            int x = n-((1<<i) - 1);
            int t =  1<<i;
            if (x <= 0) return sum;
            if ((x/t) % 2  == 0) {
                sum += (t * (x/(2*t))) + x%t;
            } else {
               sum+= t  * (((x/t) + 1) / 2);
            }
            
        }
        return sum;
    }
}
