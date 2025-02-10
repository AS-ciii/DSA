package Hashing;

class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int ele : a) {
            freq.put(ele, freq.getOrDefault(ele, 0)+1);
        }
        
        for(int ele : b) {
            if(freq.getOrDefault(ele, 0)>0) {
                if(!res.contains(ele)) res.add(ele);
                freq.put(ele, freq.get(ele)-1);
            }
        }
        
        return res;
    }
}
