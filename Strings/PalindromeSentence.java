package Strings;

class Solution {

    public boolean sentencePalindrome(String s) {
       int front = 0;
       int rear = s.length()-1;
       
       while(front<=rear) {
           if(!Character.isLetterOrDigit(s.charAt(front))) front++;
           else if(!Character.isLetterOrDigit(s.charAt(rear))) rear--;
           else {
               if(Character.toLowerCase(s.charAt(front))==Character.toLowerCase(s.charAt(rear))) {
                   front++; rear--;
               } else return false;
           }
       }
       return true;
       
    }
}
