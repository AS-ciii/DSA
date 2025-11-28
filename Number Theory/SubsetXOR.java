class Solution {
    public List<Integer> subsetXOR(int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        int T = 0;
        for (int i = 1; i <= n; i++) T ^= i;

        if (T == n) {  // Case 1
            for (int i = 1; i <= n; i++) ans.add(i);
            return ans;
        }

        int x = T ^ n;  // number to remove if possible

        if (1 <= x && x <= n) {  // Case 2: remove one number
            for (int i = 1; i <= n; i++)
                if (i != x) ans.add(i);
            return ans;
        }

        // Case 3: remove two numbers
        int y = x ^ 1;  // remove 1 and y
        for (int i = 1; i <= n; i++)
            if (i != 1 && i != y) ans.add(i);

        return ans;
    }
}
