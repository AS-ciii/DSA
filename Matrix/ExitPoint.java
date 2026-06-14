class Solution {
    public List<Integer> exitPoint(int[][] mat) {
         int n = mat.length;
        int m = mat[0].length;

        // Directions: 0 = right, 1 = down, 2 = left, 3 = up
        int dir = 0;
        int i = 0, j = 0;

        while (true) {
            if (mat[i][j] == 1) {
                mat[i][j] = 0;       // flip to 0
                dir = (dir + 1) % 4; // turn clockwise
            }

            // Move in current direction
            if (dir == 0) { // right
                j++;
            } else if (dir == 1) { // down
                i++;
            } else if (dir == 2) { // left
                j--;
            } else { // up
                i--;
            }

            // Boundary check
            if (i < 0) {
                return Arrays.asList(0, j);
            } else if (j < 0) {
                return Arrays.asList(i, 0);
            } else if (i >= n) {
                return Arrays.asList(n - 1, j);
            } else if (j >= m) {
                return Arrays.asList(i, m - 1);
            }
        }
    }
}
