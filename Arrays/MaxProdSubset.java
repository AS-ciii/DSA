import java.math.BigInteger;

class Solution {
    public int findMaxProduct(int[] arr) {

        int n = arr.length;
        long MOD = 1000000007L;

       if (n == 1)
            return arr[0];
            
        int negCount = 0;
        int zeroCount = 0;
        int maxNegative = Integer.MIN_VALUE;

        BigInteger product = BigInteger.ONE;

        for (int num : arr) {

            if (num == 0) {
                zeroCount++;
                continue;
            }

            product = product.multiply(BigInteger.valueOf(num));

            if (num < 0) {
                negCount++;
                maxNegative = Math.max(maxNegative, num);
            }
        }


        if (zeroCount == n)
            return 0;

        
        if (negCount == 1 && negCount + zeroCount == n)
            return 0;

       
        if ((negCount & 1) == 1) {
            product = product.divide(BigInteger.valueOf(maxNegative));
        }

        BigInteger mod = BigInteger.valueOf(MOD);
        return product.mod(mod).intValue();
    }
}
