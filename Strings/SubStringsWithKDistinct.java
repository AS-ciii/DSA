class Solution {
    public int countSubstr(String s, int k) {
        return helper(s, k) - helper(s, k - 1);
    }

    private int helper(String s, int k) {
        int left = 0, right = 0, count = 0, distinctCount = 0;
        int[] freq = new int[256]; // Array for character frequency (assuming ASCII)

        while (right < s.length()) {
            if (freq[s.charAt(right)] == 0) {
                distinctCount++; // New distinct character
            }
            freq[s.charAt(right)]++;

            while (distinctCount > k) {
                freq[s.charAt(left)]--;
                if (freq[s.charAt(left)] == 0) {
                    distinctCount--; // Remove distinct character
                }
                left++;
            }

            count += right - left + 1;
            right++;
        }
        return count;
    }
}
