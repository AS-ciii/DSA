package Strings;

class Solution {
    public List<String> camelCase(String[] arr, String pat) {
        List<String> matched = new ArrayList<>();
        for(String s : arr) {
            StringBuilder temp = new StringBuilder();
            for(int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                if(Character.toUpperCase(c)==c) {
                    temp.append(c);
                }
            }
            boolean flag = true;
            if(temp.length() < pat.length()) continue;
            
            for(int i=0; i<pat.length(); i++) {
                if(temp.charAt(i)!=pat.charAt(i)) {
                    flag = false;
                    break;
                }    
            }
            
            if(flag) matched.add(s);
        }
        
        return matched;
    }
}
