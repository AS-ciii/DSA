class Solution {
	public boolean divisibleByK(int[] arr, int k) {
		// code here
               //Kaustuv Kumar
		if (arr.length > k)
			return true;
		
		boolean[] dp = new boolean[k];
		
		for (int num : arr) {
			boolean[] nextDp = dp.clone();
			int rem = num % k;
			if (rem == 0)
				return true;
			nextDp[rem] = true;
			
			for (int i = 0; i < k; i++) {
				if (dp[i]) {
					int nextRem = (i + rem) % k;
					if (nextRem == 0)
						return true;
					nextDp[nextRem] = true;
				}
			}
			dp = nextDp;
		}
		return dp[0];
	}
}
