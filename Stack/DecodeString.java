package Stack;

class Solution {
    static String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<StringBuilder> string = new Stack<>();
        
        StringBuilder current = new StringBuilder();
        
        int k = 0;
        
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) k = k*10+(c-'0'); 
            else if(c=='[') {
                count.push(k);
                string.push(current);
                current = new StringBuilder();
                k = 0;
            } else if(c==']') {
                int repeat = count.pop();
                StringBuilder decoded = string.pop();
                for(int i=0; i<repeat; i++) decoded.append(current);
                current = decoded;
            } else current.append(c);
        }
        
        return current.toString();
    }
}