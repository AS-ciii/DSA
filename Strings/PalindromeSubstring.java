class Solution {
    public int countPS(String s) {
        // code here
       //  String s = "abaab";
      // System.out.println(countPalindromicSubstrings(s));
   // }

       // static int countPalindromicSubstrings(String s) {
        int count = 0;
        int n = s.length();

        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;

            // expand while valid and palindrome
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 >= 2) { // only count length >= 2
                    count++;
                }
                left--;
                right++;
            }
        }
        return count;
    }
}
