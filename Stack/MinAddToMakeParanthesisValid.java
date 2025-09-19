class Solution {
    public int minParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push('(');
            } else if (s.charAt(i) == ')') {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else {
                    st.push(')');
                }
            }
        }
        return st.size();
    }
}

