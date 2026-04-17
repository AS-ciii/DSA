class Solution {
    boolean canFormPalindrome(String s) {
        // code here
        int[] freq=new int[26];
        for(int i=0;i<s.length(); i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }
        int oddCount=0;
        for(int count :freq) {
            if(count % 2!=0) {
                oddCount++;
            }
        }
        if(oddCount>1) {
            return false;
        }
        return true;
    }
}
