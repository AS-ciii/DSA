package Strings;

class Solution {
    public int myAtoi(String s) {
        long integer = 0;
        int n = s.length();
        int sign = 1; //positive default
        int i = 0;
        
        while(i<n && s.charAt(i)==' ') i++;
        
        if(i<n && (s.charAt(i)=='+' || s.charAt(i)=='-')) {
            sign = s.charAt(i)=='-'?-1:1;
            i++;
        }
        
        while(i<n && Character.isDigit(s.charAt(i))) {
            integer = integer*10+(s.charAt(i)-'0');
            if(sign*integer >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign*integer <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        
        return (int)(sign*integer);
    }
}