class Solution {
    public boolean stringStack(String pat, String tar) {
        // code here
        int i = pat.length()-1;
        int j = tar.length()-1;
        
        int c = 0;
        while (i >= 0  && j >= 0) {
            if (pat.charAt(i) == tar.charAt(j) && c%2 == 0){
                c = 0;
                j--;
            } else {
                c++;
            }
            
            i--;
        }
        
        return j < 0;
    }
}
