import java.util.*;

class Solution {
    public ArrayList<String> possibleWords(int[] arr) {
        ArrayList<String> res = new ArrayList<>();
        if (arr == null || arr.length == 0) return res;

        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<char[]> choicesList = new ArrayList<>();
        
        for (int d : arr) {
            if (d >= 2 && d <= 9) {
                choicesList.add(map[d].toCharArray());
            }
        }
        if (choicesList.isEmpty()) return res;

        int n = choicesList.size();
        int[] idx = new int[n];
        char[] word = new char[n];

        while (true) {
            for (int i = 0; i < n; i++) word[i] = choicesList.get(i)[idx[i]];
            res.add(new String(word));

            int p = n - 1;
            while (p >= 0) {
                idx[p]++;
                if (idx[p] < choicesList.get(p).length) break;
                idx[p] = 0;
                p--;
            }
            if (p < 0) break;
        }

        return res;
    }
}
