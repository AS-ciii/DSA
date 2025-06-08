import java.math.BigInteger;
class Solution {
    public boolean isSumString(String s) {
        // code here
       int n = s.length();

        
        for (int len1 = 1; len1 <= n - 2; len1++) {
            for (int len2 = 1; len1 + len2 <= n - 1; len2++) {

               
                if ((s.charAt(0) == '0' && len1 > 1) ||
                    (s.charAt(len1) == '0' && len2 > 1)) {
                    continue;
                }

                if (isValidSplit(s, len1, len2)) {
                    return true;
                }
            }
        }
        return false;
    }

   
    private boolean isValidSplit(String s, int len1, int len2) {

        BigInteger first  = new BigInteger(s.substring(0, len1));
        BigInteger second = new BigInteger(s.substring(len1, len1 + len2));
        int pos = len1 + len2;

        while (pos < s.length()) {
            BigInteger sum = first.add(second);
            String sumStr = sum.toString();

           
            if (!s.startsWith(sumStr, pos)) {
                return false;
            }

            
            pos   += sumStr.length();
            first  = second;
            second = sum;
        }
        return true;        
    }
}
