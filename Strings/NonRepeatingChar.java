package Strings;

class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        int count[] = new int[27];
        
        for(int i=0; i<s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }
        
        for(int i=0; i<s.length(); i++) {
             if(count[s.charAt(i)-'a']==1) return s.charAt(i);
        }
        
        return '$';
    }
}
