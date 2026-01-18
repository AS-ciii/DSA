class Solution {
    public String removeKdig(String S, int k) {
        int n = S.length();
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = S.charAt(i);

            while (!s.isEmpty() && k > 0 && ch < s.peek()) {
                s.pop();
                k--;
            }

            if (!s.isEmpty() || ch != '0') {
                s.push(ch);
            }
        }

        while (!s.isEmpty() && k > 0) {
            s.pop();
            k--;
        }

        if (s.isEmpty()) return "0";

        StringBuilder str = new StringBuilder();
        while (!s.isEmpty()) {
            str.append(s.pop());
        }

        return str.reverse().toString();
    }
}
