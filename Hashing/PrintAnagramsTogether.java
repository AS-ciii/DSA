package Hashing;

class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String str : arr) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String str1 = new String(temp);
            map.putIfAbsent(str1, new ArrayList<>());
            map.get(str1).add(str);
        }
        
        for(ArrayList<String> list : map.values()) {
            res.add(list);
        }
        
        return res;
    }
}
