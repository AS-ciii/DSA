class Solution {
    int maxPeopleDefeated(int p) {
        long l = 1;
        long r = (long) Math.sqrt(p);
        int ans = 0;

        while (l <= r) {
            long mid = (l + r) / 2;
            long sum = (mid * (mid + 1) * (2 * mid + 1)) / 6;

            if (sum <= p) {
                ans = (int) mid; // valid number of people
                l = mid + 1;     // try for more
            } else {
                r = mid - 1;     // too large
            }
        }

        return ans;
    }
}
