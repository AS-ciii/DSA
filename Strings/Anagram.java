package Strings;

class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s1, String s2) {
        int[] hash = new int[26];
        if(s1.length()!=s2.length()) return false;
        for(int i=0; i<s1.length(); i++) {
            hash[s1.charAt(i)-'a']++;
        }
        
        for(int i=0; i<s2.length(); i++) {
            hash[s2.charAt(i)-'a']--;
            if(hash[s2.charAt(i)-'a']<0) return false;
        }
        
        return true;
    }
}
