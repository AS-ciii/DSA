class Solution {
    public String largestSwap(String s) {
        // code here
        char ch[]=s.toCharArray();
        int ind=ch.length-1;
        
        int pair[]={-1, -1};
        
        for(int i=ch.length-1; i>=0; i--){
            if(ch[i] > ch[ind]){
                ind=i;
            }else if(ch[i] < ch[ind]){
                pair[0]=i;
                pair[1]=ind;
            }
        }
        
        if(pair[0] == -1) return s;
        
        char c=ch[pair[0]];
        ch[pair[0]]=ch[pair[1]];
        ch[pair[1]]=c;
        
        return new String(ch);
    }
}
