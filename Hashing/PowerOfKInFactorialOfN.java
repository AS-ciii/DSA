import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxKPower(int n, int k) {
        if (k == 1) {
            return Integer.MAX_VALUE;
        }

        Map<Integer, Integer> pfk = new HashMap<>();
        int tK = k;
        for (int i = 2; i * i <= tK; i++) {
            while (tK % i == 0) {
                pfk.put(i, pfk.getOrDefault(i, 0) + 1);
                tK /= i;
            }
        }
        if (tK > 1) {
            pfk.put(tK, pfk.getOrDefault(tK, 0) + 1);
        }

        int mX = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> e : pfk.entrySet()) {
            int p = e.getKey();
            int eK = e.getValue();

            long cNf = 0;
            long pP = p;
            while (pP <= n) {
                cNf += (n / pP);
                if (pP > n / p) {
                    break;
                }
                pP *= p;
            }
            
            mX = Math.min(mX, (int) (cNf / eK));
        }

        return mX;
    }
}
