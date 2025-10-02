class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        // code here
     
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> result,
                           ArrayList<Integer> current,
                           int k, int n, int start) {

        if (current.size() == k && n == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (n < 0 || current.size() > k) return;

        for (int i = start; i <= 9; i++) {
            current.add(i);
            backtrack(result, current, k, n - i, i + 1);
            current.remove(current.size() - 1);
        }  

     }
}

