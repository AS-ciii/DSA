package Strings;

class Solution {
    public static int minChar(String s) {
        String checkPat = s + "#" + new StringBuilder(s).reverse().toString();
        int len = 0;
        int i = 1;
        int[] lps = new int[checkPat.length()];
        lps[0] = 0;
        
        while(i<checkPat.length()) {
            if(checkPat.charAt(i)==checkPat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len!=0) {
                    len = lps[len-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return s.length()-lps[checkPat.length()-1];
    }
}
