class Solution {
    boolean checkPalindrome(String s){
        //String res = s1+s2;
        int l = 0;
        int r = s.length()-1;
        while(l<r){
           if(s.charAt(l) != s.charAt(r)){
               return false;
           }
           l++;
           r--;
        }
    return true;
    }
    public boolean palindromePair(String[] arr) {
        // Code here
        int n = arr.length;
        HashMap<String,Integer> hm = new HashMap<>();
        for(String s:arr) hm.put(s,hm.getOrDefault(s,0)+1);
        for(String s:arr){
        for(int i=0;i<=s.length();i++){
           String left = s.substring(0,i);
           String right = s.substring(i);
           if(checkPalindrome(left)){
               String rev = new StringBuilder(right).reverse().toString();
               if(hm.containsKey(rev)){
                  if(!rev.equals(s) || hm.get(s)>1) return true;
               }
            }
            if(i != s.length() && checkPalindrome(right)){
               String rev = new StringBuilder(left).reverse().toString();
              if( hm.containsKey(rev)){
                   
                  if(!rev.equals(s) || hm.get(s)>1) return true;
               }
            }
        }
    }
    return false;
    }
}
