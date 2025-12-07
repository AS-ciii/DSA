class Solution {
    int distinctSubseq(String str) {
        int mod = 1000000007;
        int n = str.length();
        
        // dp[i] = number of distinct subsequences considering first i characters
        int dp[] = new int[n+1];
        dp[0] = 1;  // Base case: empty subsequence
        
        // Map to store the last occurrence index of each character
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 1; i <= n; i++){
            
            // Step 1: Every subsequence formed till (i-1) can either include or exclude the new character
            // So total subsequences double
            dp[i] = (dp[i-1] * 2) % mod;
            
            char ch = str.charAt(i-1);
            
            // Step 2: If the current character has occurred before,
            // subtract the subsequences counted before its previous occurrence
            if(map.containsKey(ch)){
                // subtract the duplicate contribution
                dp[i] = (dp[i] - dp[ map.get(ch) ] + mod) % mod;
            }
            
            // Step 3: Update last occurrence of character
            map.put(ch, i-1);
        }
        
        // dp[n] gives total distinct subsequences including empty subsequence
        return dp[n];
    }
}

