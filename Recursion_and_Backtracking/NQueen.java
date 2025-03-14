package Recursion_and_Backtracking;

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        solve(0, n, new ArrayList<>(), new HashSet<>(), new HashSet<>(), new HashSet<>(), res);
        return res;
    }
    
    private void solve(int row, int n, ArrayList<Integer> queens, HashSet<Integer> cols, HashSet<Integer> d1, HashSet<Integer> d2, ArrayList<ArrayList<Integer>> res) {
        if(row==n) {
            res.add(new ArrayList<>(queens));
            return;
        }
        
        for(int col=1; col<=n; col++) {
            
            if(cols.contains(col) || d1.contains(row-col) || d2.contains(row+col)) continue;
            queens.add(col);
            cols.add(col);
            d1.add(row-col);
            d2.add(row+col);
            
            solve(row+1, n, queens, cols, d1, d2, res);
            
            queens.remove(queens.size()-1);
            cols.remove(col);
            d1.remove(row-col);
            d2.remove(row+col);
        }
    }
}
