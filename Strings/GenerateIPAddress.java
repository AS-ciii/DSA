class Solution {
    public ArrayList<String> generateIp(String s) {
        ArrayList<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, ArrayList<String> parts, ArrayList<String> result) {
        if (parts.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", parts));
            }
            return;
        }

        int remaining = 4 - parts.size();
        int charsLeft = s.length() - start;

        if (charsLeft < remaining || charsLeft > remaining * 3) return;

        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break;

            String segment = s.substring(start, start + len);

            if (len > 1 && segment.charAt(0) == '0') break;
            if (Integer.parseInt(segment) > 255) break;

            parts.add(segment);
            backtrack(s, start + len, parts, result);
            parts.remove(parts.size() - 1);
        }
    }
}
