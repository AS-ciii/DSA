class Solution {
    boolean sameFreq(String s) {
        // code here
        Map<Character,Integer> freq =  new HashMap<>();
        for(char c : s.toCharArray()){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        Map<Integer,Integer> count = new TreeMap<>();
        for(int i : freq.values()){
            count.put(i,count.getOrDefault(i,0)+1);
        }
        
        if(count.size()==1){
            return true;
        }else if(count.size()==2){
            List<Integer> li = new ArrayList<>(count.keySet());
            
            int f1 = li.get(0);
            int f2 = li.get(1);
            
            int c1 = count.get(f1);
            int c2 = count.get(f2);

 if(f1==1&&c1==1 || f2 == f1+1 && c2==1){
                return true;
            }
        }
        return false;
    }
}
