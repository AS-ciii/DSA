package Strings;

class Solution {
    public String addBinary(String s1, String s2) {
        StringBuilder ans = new StringBuilder();
        int i = s1.length()-1;
        int j = s2.length()-1;
        int carry = 0;
        
        while(i>=0 || j>=0 || carry>0) {
            int sum = carry;
            if(i>=0) sum += s1.charAt(i)-'0';
            if(j>=0) sum += s2.charAt(j)-'0';
            ans.append(sum%2);
            carry = sum/2;
            i--; j--;
        }
        
        if(carry!=0) ans.append(carry);
        
        while (ans.length() > 1 && ans.charAt(ans.length() - 1) == '0') {
            ans.setLength(ans.length() - 1);
        }
        
        return ans.reverse().toString();
    }
}
