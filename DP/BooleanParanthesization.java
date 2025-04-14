package DP;

class Solution {
    static int countWays(String s) {
        HashMap<String, Long> m = new HashMap<>();
        return (int) countWays(s, 0, s.length()-1, true, m);
    }
    
    static long countWays(String s, int i, int j, boolean isTrue, HashMap<String, Long> m) {
        if(i>j) return 0;
        if(i==j) return (isTrue==(s.charAt(i)=='T'))?1:0;
        
        String key = i+"_"+j+"_"+isTrue;
        
        if(m.containsKey(key)) return m.get(key);
        long ways = 0;

        for(int k=i+1; k<j; k+=2) {
            char op = s.charAt(k);
            
            long lt = countWays(s, i, k-1, true, m);
            long lf = countWays(s, i, k-1, false, m);
            long rt = countWays(s, k+1, j, true, m);
            long rf = countWays(s, k+1, j, false, m);
            
            long total = (lt+lf)*(rt+rf);
            
            long trueWays = 0;
            
            if(op=='&') trueWays = (lt*rt);
            else if(op=='|') trueWays = (lt*rt+lt*rf+lf*rt);
            else if(op=='^') trueWays = (lt*rf+lf*rt);
            
            ways = (ways + (isTrue? trueWays : (total-trueWays)));
        }
        
        m.put(key, ways);
        return ways;
    }
}
