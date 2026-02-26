class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {

            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            int idx1 = c1 - 'a';
            int idx2 = c2 - 'a';

            if (map1[idx1] != 0 || map2[idx2] != 0) {
                if (map1[idx1] != c2 || map2[idx2] != c1) {
                    return false;
                }
            } else {
                map1[idx1] = c2;
                map2[idx2] = c1;
            }
        }

        return true;
    }
}
