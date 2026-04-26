class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        
        HashSet<Integer> bs= new HashSet<>();
        HashSet<Integer> cs= new HashSet<>();
        ArrayList<Integer> ans= new ArrayList<>();
        HashSet<Integer> set= new HashSet<>();
        
        for(int k: b){
            bs.add(k);
        }
        for(int k: c){
            cs.add(k);
        }
        
        for(int k: a){
            if(bs.contains(k) && cs.contains(k) && !set.contains(k)){
                set.add(k);
                ans.add(k);
            }
        }
        
        return ans;
        
    }
}
