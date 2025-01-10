package Strings;

class Solution {
    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        if(s1==null || s2==null) return false;
        if(s1.length()!=s2.length()) return false;
        if(s1.equals(s2)) return true;
        String s3 = s1+s1;
        
        return (s3.lastIndexOf(s2)>0);
    }
}
