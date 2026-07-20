class Solution {
    public ArrayList<String> findPrefixes(String[] arr) {
        // code here
        ArrayList<String> res=new ArrayList<String>();
        int n=arr.length;
        Trie t=new Trie();
        
        for(int i=0;i<n;i++){
            t.insert(arr[i]);
        }
        
        for(int i=0;i<n;i++){
            res.add(t.uprefix(arr[i]));
        }
        
        return res;
    }
    
    class TrieNode{
        TrieNode child[];
        int freq,child_cnt;
        TrieNode(){
            child=new TrieNode[26];
            freq=0;
            child_cnt=0;
        }
    }
    
    class Trie{
        TrieNode root=new TrieNode();
        
        void insert(String s){
            TrieNode curr=root;
            for(char x:s.toCharArray()){
                
                if(curr.child[x-'a']==null){
                   curr.child[x-'a']=new TrieNode();
                    curr.child_cnt++;
                }
                curr=curr.child[x-'a'];
                curr.freq++;
            }
        }
        
        String uprefix(String s){
            TrieNode curr=root;
            StringBuilder sb=new StringBuilder();
            int n=s.length();
            
            for(int i=0;i<n;i++){
                char x=s.charAt(i);
                if(curr.freq==1 && (curr.child_cnt==1 || curr.child_cnt==0)){
                    return sb.toString();
                }
                else{
                    sb.append(x);
                    curr=curr.child[x-'a'];
                }
            }
            return sb.toString();
        }
    }
}
