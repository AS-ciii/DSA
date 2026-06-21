class Solution {
    public String chooseSwap(String s) {
        // code here
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        char a = '1';
        char b = '1';
        
        boolean[] seen = new boolean[26];
        for(char ch : s.toCharArray()){
            boolean found = false;
            seen[ch-'a'] = true;
            for(int i = 0; i<ch-'a'; i++){
                if(seen[i] == true) continue;
                if(freq[i] > 0){
                    a = ch;
                    b = ((char)('a'+i));
                    found = true;
                    break;
                }
            }
            if(found) break;
        }
        if(a == '1') return s;
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == a){
                sb.append(b);
            } else if(ch == b){
                sb.append(a);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
