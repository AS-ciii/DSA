class Solution {
    int countWays(int n, int k) {

        if (n == 1) return k;
        if (n == 2) return k * k;

        int same = k;          // ways for 2 posts same
        int diff = k * (k - 1); // ways for 2 posts different

        for (int i = 3; i <= n; i++) {
            int prevSame = same;
            int prevDiff = diff;

            same = prevDiff; // must come from previous diff
            diff = (prevSame + prevDiff) * (k - 1);
        }

        return same + diff;
    }
}
