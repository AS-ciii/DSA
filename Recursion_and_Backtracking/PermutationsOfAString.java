package Recursion_and_Backtracking;

class Solution {
    public ArrayList<String> findPermutation(String s) {
        Set<String> res = new HashSet<>();
        boolean[] visited = new boolean[s.length()];
        Permutations(s, res, "", visited);
        return new ArrayList(res);
    }
    
    public static void Permutations(String s, Set<String> res, String curr, boolean[] visited) {
        if(curr.length() == s.length()) {
            res.add(curr);
            return;
        }
        
        for(int i=0; i<s.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                Permutations(s, res, curr+s.charAt(i), visited);
                visited[i] = false;
            }
        }
    }
}
