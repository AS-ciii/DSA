package DP;

class Solution {
    static String longestPalindrome(String s) {
        if(s == null || s.length() <1) return "";
        
        int start = 0, end = 0;
        
        for(int i=0; i<s.length(); i++) {
            int l1 = i, r1 = i;
            
            while(l1>=0 && r1 <s.length() && s.charAt(l1)==s.charAt(r1)) {
                if(r1-l1 > end-start) {
                    start = l1;
                    end = r1;
                }
                l1--;
                r1++;
            }
            
            int l2 = i, r2 = i+1;
            
            while(l2>=0 && r2 <s.length() && s.charAt(l2)==s.charAt(r2)) {
                if(r2-l2 > end-start) {
                    start = l2;
                    end = r2;
                }
                l2--;
                r2++;
            }
        
            
        }
        return s.substring(start, end+1);
        
    }
}
