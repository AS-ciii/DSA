class Solution {
    public int smallestSubstring(String s) {
        int[] count = new int[3]; // freq of '0','1','2'
        int left = 0, minLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - '0']++;// '0' - '0' = 0   '1' - '0' = 1   '2' - '0' = 2

            // shrink window when all 3 are present
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                minLen = Math.min(minLen, right - left + 1);
                count[s.charAt(left) - '0']--;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
