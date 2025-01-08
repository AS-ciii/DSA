package Strings;

class Solution {

    ArrayList<Integer> search(String pat, String txt) {
        int[] lps = new int[pat.length()];
        int i = 1;
        int len = 0;
        lps[0] = 0;
        
        while(i<pat.length()) {
            if(pat.charAt(i)==pat.charAt(len)) {
                lps[i] = len+1;
                len++; i++;
            } else {
                if(len!=0) {
                    len = lps[len-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        ArrayList<Integer> occurences = new ArrayList<>();
        i =0;
        int j = 0;
        while(i<txt.length()) {
            if(pat.charAt(j)==txt.charAt(i)) {
                i++; j++;
                if(j==pat.length()) {
                    occurences.add(i-j);
                    j = lps[j-1];
                }
            } else {
                if(j!=0) {
                    j = lps[j-1];
                } else {
                    i++;
                }
            }
        }
        
        return occurences;
    }
}
