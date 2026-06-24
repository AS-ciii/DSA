class Solution {
     boolean solve(int i, int j, int[][] mat, ArrayList<ArrayList<Integer>> ans,
                  int[][] dp) {
        int n = mat.length;
        if (i == n - 1 && j == n - 1) {
            ans.get(i).set(j, 1);
            return true;
        }
        if (mat[i][j] == 0) return false;
        if (dp[i][j] != -1) return dp[i][j] == 1;

        ans.get(i).set(j, 1);
        int jump = mat[i][j];
        for (int step = 1; step <= jump; step++) {
            if (j + step < n && solve(i, j + step, mat, ans, dp)) {
                dp[i][j] = 1;
                return true;
            }
            if (i + step < n && solve(i + step, j, mat, ans, dp)) {
                dp[i][j] = 1;
                return true;
            }
        }
        ans.get(i).set(j, 0);
        dp[i][j] = 0;
        return false;
    }
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        int n = mat.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>(Collections.nCopies(n, 0)));
        }
        if (n == 1) {
            ans.get(0).set(0, 1);
            return ans;
        }
        if (mat[0][0] == 0) {
            ans.clear();
            ans.add(new ArrayList<>(Arrays.asList(-1)));
            return ans;
        }

        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        if (!solve(0, 0, mat, ans, dp)) {
            ans.clear();
            ans.add(new ArrayList<>(Arrays.asList(-1)));
            return ans;
        }

        return ans;
    }
}
