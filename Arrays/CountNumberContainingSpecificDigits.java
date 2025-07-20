class Solution {
    public static int countValid(int n, int[] arr) {
        // code here
        Set<Integer> forbid = new HashSet<>();
        for (int a : arr) {
            forbid.add(a);
        }
        Set<Integer> allowed = new HashSet<>();
        for (int i = 0; i <= 9; i++) {
            if (!forbid.contains(i)) {
                allowed.add(i);
            }
        }
        long totalWays = (long) (9L * Math.pow(10, n - 1));
        if (n == 1) {
            totalWays = 9;
        }
        long unwanted = 0;
        int m = allowed.size();
        long choice = allowed.contains(0) ? m - 1 : m;
        unwanted = (long) (choice * Math.pow(m,n-1));
        return (int) (totalWays - unwanted);
    }
}

