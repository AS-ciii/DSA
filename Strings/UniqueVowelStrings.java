class Solution {
    public int vowelCount(String s) {
        // code here
        int len=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        ArrayList<Character> list=new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        for(int i=0;i<len;i++){
            char ch=s.charAt(i);
            if(list.contains(ch)){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
        }
        if (map.isEmpty()) return 0;
        
        int n=map.size();
        int factorial=fact(n);
        
        int ans=1;
        for(int val:map.values()){
            ans*=val;
        }
        return ans*factorial;
    }
    public int fact(int n){
        int ans=1;
        for(int i=2;i<=n;i++){
            ans*=i;
        }
        return ans;
    }
}
