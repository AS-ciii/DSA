class Solution {
    public List<String> validParenthesis(String s) {
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        visited.add(s);
        boolean found = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                String curr = queue.poll();

                if (isValid(curr)) {
                    result.add(curr);
                    found = true;
                }

                if (found) continue;

                // Try removing each parenthesis one at a time
                for (int j = 0; j < curr.length(); j++) {
                    if (Character.isLetter(curr.charAt(j))) continue;

                    String next = curr.substring(0, j) + curr.substring(j + 1);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }

            // Stop BFS once valid strings are found at this level
            if (found) break;
        }

        if (result.isEmpty()) result.add("");

        Collections.sort(result);
        return result;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') count++;
            else if (ch == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}
