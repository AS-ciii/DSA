class trie{
    trie arr[]=new  trie[26];
}


class Solution {
    public static int countSubs(String s) {
        trie start=new trie();
        int count=0;
        for(int i=0;i<s.length();i++){
              trie temp=start;
            for(int j=i;j<s.length();j++){
                if(temp.arr[s.charAt(j)-'a']==null){
                    temp.arr[s.charAt(j)-'a']=new trie();
                    count++;
                }
                temp=temp.arr[s.charAt(j)-'a'];
            }
        }
        return count;
    }
}
