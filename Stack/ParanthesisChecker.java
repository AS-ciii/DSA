package Stack;

class Solution {
    static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char ch : s.toCharArray()) {
            if(ch=='(' || ch=='[' || ch=='{') stack.push(ch);
            else {
                if(stack.isEmpty()) return false;
                
                char br = stack.pop();
                if((ch==')' && br!='(') || (ch=='}' && br!='{') || (ch==']' && br!='[')) return false;
            }
        }
        
        return stack.isEmpty();
    }
}
