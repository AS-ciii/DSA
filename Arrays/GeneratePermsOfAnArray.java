class Solution {
    static ArrayList<ArrayList<Integer>> res;
    public static void solve(int[] arr, boolean[] used, ArrayList<Integer> curr){
        if(curr.size()==arr.length){
            res.add(new ArrayList<>(curr)); // if all the space is filled
            return;
        }
        
        for(int i=0; i<arr.length; i++){
            if(!used[i]){ // if not used yet
                curr.add(arr[i]); // add to curr permut
                used[i] = true; // mark it as used
                solve(arr, used, curr); // move further
                used[i] = false; // backtrack for other permutations
                curr.remove(curr.size()-1); // backtrack
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        res = new ArrayList<>(); // ans
        boolean[] used = new boolean[arr.length]; // to track used items
        solve(arr, used, new ArrayList<>()); // recursion
        return res; // ans
    }
};
