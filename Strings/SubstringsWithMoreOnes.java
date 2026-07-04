import java.util.*;

class Solution {

    static class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 2];
        }

        void update(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public int countSubstring(String s) {

        int n = s.length();

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (s.charAt(i) == '1' ? 1 : -1);
        }

        int[] sorted = prefix.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();

        int rank = 1;
        for (int x : sorted) {
            if (!map.containsKey(x))
                map.put(x, rank++);
        }

        Fenwick ft = new Fenwick(rank + 2);

        long ans = 0;

        for (int p : prefix) {
            int r = map.get(p);

            ans += ft.query(r - 1);

            ft.update(r, 1);
        }

        return (int) ans;
    }
}
