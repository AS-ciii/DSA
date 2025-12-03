class Solution {
    public int tsp(int[][] cost) {
        int n = cost.length;
        if (n == 0) return 0;
        if (n == 1) return 0; // start and end at city 0, no travel

        int FULL = (1 << n);
        int INF = Integer.MAX_VALUE / 4; // avoid overflow when adding

        // dp[mask][i] = minimum cost to visit set 'mask' and finish at city i.
        int[][] dp = new int[FULL][n];
        for (int m = 0; m < FULL; m++) {
            for (int i = 0; i < n; i++) dp[m][i] = INF;
        }

        // start at city 0, mask with only city 0 visited
        dp[1 << 0][0] = 0;

        // iterate over masks
        for (int mask = 0; mask < FULL; mask++) {
            // we only consider masks that include city 0 (we always start from 0)
            if ((mask & 1) == 0) continue;

            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) == 0) continue; // u not in mask
                int cur = dp[mask][u];
                if (cur == INF) continue;

                // try to go to every city v not yet in mask
                for (int v = 0; v < n; v++) {
                    if ((mask & (1 << v)) != 0) continue; // already visited
                    int nextMask = mask | (1 << v);
                    int cand = cur + cost[u][v];
                    if (cand < dp[nextMask][v]) dp[nextMask][v] = cand;
                }
            }
        }

        // close the tour: return to city 0
        int ans = INF;
        int fullMask = FULL - 1;
        for (int u = 0; u < n; u++) {
            if (dp[fullMask][u] == INF) continue;
            int total = dp[fullMask][u] + cost[u][0];
            if (total < ans) ans = total;
        }

        return ans;
    }
}
