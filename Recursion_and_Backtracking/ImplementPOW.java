package Recursion_and_Backtracking;

class Solution {
    double power(double b, int e) {
        if(e==0) return 1;
        
        double res = 1;
        int expo = Math.abs(e);
        
        while(expo>0) {
            if((expo&1)==1) res *= b;
            b *= b;
            expo >>= 1;
        }
        
        return (e<0)?1.0/res:res;
    }
}
