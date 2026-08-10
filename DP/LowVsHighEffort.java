class Solution {

 

    public int maxTask(int[] h, int[] l) {

        int n = h.length;

        int prev2 = 0; // Represents dp[i]

        int prev1 = 0; // Represents dp[i+1]

        

        for (int i = 0; i < n; i++) {

            int curr = Math.max(h[i] + prev2, l[i] + prev1);

            prev2 = prev1;

            prev1 = curr;

        }

        

        return prev1;    

    }

}
