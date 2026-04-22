class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        int[] pref = new int[arr.length];
        
        pref[0] = arr[0];
        
        
        for(int i=1; i<arr.length; i++){
           pref[i] = pref[i-1]+arr[i];
        }
        
        for(int i=0; i<queries.length; i++){
            
            int l = queries[i][0];
            int r = queries[i][1];
            int sum;
           if(l == 0){
             sum = pref[r];
           } else {
            sum = pref[r] - pref[l - 1];
           }
    
            res.add(sum / (r - l + 1));
          
        }
        
        return res;
    }
}
