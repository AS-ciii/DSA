class Solution {
    public ArrayList<Integer> asciirange(String s) {
        // code here
        Map<Character,Integer> mp=new HashMap<>();
        for(char ch:s.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        ArrayList<Integer> l1=new ArrayList<>();
        for(char ch:mp.keySet()){
            if(mp.get(ch)>1){
                int st=s.indexOf(ch);
                int ed=s.lastIndexOf(ch);
                int sum=0;
                if(ed-st>1){
                for(int i=st+1;i<ed;i++){
                    sum+= s.charAt(i);
                  }
                l1.add(sum);
                }
            }
        }
        return l1;
    }
}
