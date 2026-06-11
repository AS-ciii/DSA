class Solution {
    public int findIndex(String s) {
        int n = s.length();
        int ob = 0;
        int cb = 0;

        // Count total closing brackets
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ')') {
                cb++;
            }
        }

        for (int j = 0; j < n; j++) {

            if (ob == cb) {
                return j;
            }

            if (s.charAt(j) == '(') {
                ob++;
            } else {
                cb--;
            }
        }

        // Check after the last character
        if (ob == cb) {
            return n;
        }

        return -1;
    }
}
