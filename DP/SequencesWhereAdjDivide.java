class Solution {

    public int count(int n, int m) {

        // Base Case: If length is 1, there is 1 valid sequence for each ending number

        int[] prevDp = new int[m + 1];

        Arrays.fill(prevDp, 1);

        prevDp[0] = 0; // 0 is not a valid number in the sequence

 

        // Iteratively compute counts for lengths 2 up to n

        for (int len = 2; len <= n; len++) {

            int[] currDp = new int[m + 1];

            

            for (int last = 1; last <= m; last++) {

                int ans = 0;

                for (int i = 1; i <= m; i++) {

                    if (i % last == 0 || last % i == 0) {

                        ans += prevDp[i];

                    }

                }

                currDp[last] = ans;

            }

            // Move to the next length layer

            prevDp = currDp;

        }

 

        // Sum up all valid sequences of length n

        int totalCount = 0;

        for (int i = 1; i <= m; i++) {

            totalCount += prevDp[i];

        }

 

        return totalCount;

    }

}
