class Solution {
	HashMap<String, Integer>memo;
	public int zigzagSequence(int[][] mat) {
		// code here
		memo = new HashMap<>();
		int ans = Integer.MIN_VALUE;
		if (mat.length == 1) {
			for (int j = 0; j < mat[0].length; j++) {
				ans = Math.max(ans, mat[0][j]);
			}
			return ans;
		}
		
		for (int j = 0; j < mat[0].length; j++) {
			ans = Math.max(ans, dfs(mat, 0, j));
		}
		return ans;
	}
	int dfs(int[][] mat, int i, int j) {
		
		if (i == mat.length) {
			return 0;
		}
		
		String current = i + " " + j;
		
		if (memo.containsKey(current)) {
			return memo.get(current);
		}
		
		int max = Integer.MIN_VALUE;
		
		for (int nextJ = 0; nextJ < mat[0].length; nextJ++) {
			
			if (nextJ == j)
				continue;
			
			max = Math.max(max, dfs(mat, i + 1, nextJ));
		}
		
		memo.put(current, mat[i][j] + max);
		
		return memo.get(current);
	}
}
